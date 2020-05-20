package com.honor.liuxinquan.day1101;

import cn.hutool.crypto.digest.DigestUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 明传无线短信服务工具
 */
public class Test4 {
    public static void main(String[] args) {
        Test4 test4 = new Test4();
        test4.sendVerifyCodeSms("niupi", "15197178067");
    }
    private static Logger logger= LoggerFactory.getLogger(Test4.class);

    private String url="http://112.74.139.4:8002/sms3_api/jsonapi/jsonrpc2.jsp";

    private String verifyCodeUserId="204811";

    private String verifyCodePassword="b46d4319ab253281340b970c5801530f";

    private String marketingUserId="204812";

    private String marketingPassword="71d4e99adc028fbbee03dad1c7b7f8df";

    private static final String SEND = "send";
    private static final String ID = "id";
    private static final String METHOD = "method";
    private static final String PARAMS = "params";

    private static final String USERID_PARAM = "userid";
    private static final String PASSWORD_PARAM = "password";
    private static final String SEQID_PARAM = "seqid";
    private static final String SIGN_PARAM = "sign";
    private static final String SUBMIT_PARAM = "submit";

    private static final String CONTENT_SUBMIT = "content";
    private static final String PHONE_SUBMIT = "phone";

    private static final String RETURN_RESPONSE = "return";
    private static final String INFO_RESPONSE = "info";
    private static final String RESULT_RESPONSE = "result";

    /**
     * 验证码文案
     */
    private static final String CONTENT_TEXT = "验证码为";
    /**
     * 签名文案
     */
    private static final String SIGN_TEXT = "TT派糖";

    /**
     * SeqId自定义6位数字
     */
    private static final int SEQID_INT = 379584;
    /**
     * http请求成功状态码
     */
    private static final int OK_HTTP_STATUS_CODE = 200;
    /**
     * sms发送成功返回码
     */
    private static final int OK_SMS_CODE = 0;

    /**
     * 发送验证码
     * @param code
     * @param phone
     * @return
     */
    public boolean sendVerifyCodeSms(String code,String phone){
        String codeContent=CONTENT_TEXT+code+"。【"+SIGN_TEXT+"】";
        String s = this.generateSms(codeContent, phone, verifyCodeUserId, verifyCodePassword);
        return this.sendSms(s,phone);
    }

    /**
     * 发送营销内容短信
     * @param content
     * @param phone
     * @return
     */
    public boolean sendMarketingContentSms(String content,String phone){
        content=content+"。【"+SIGN_TEXT+"】";
        String s = this.generateSms(content, phone, marketingUserId, marketingPassword);
        return this.sendSms(s,phone);
    }

    /**
     * Sms 通用内容组装魔板
     * @return
     */
    public String generateSms(String content, String phone, String paramUserId, String password){
        JSONObject submitJson = new JSONObject();
        submitJson.put(CONTENT_SUBMIT,content);
        submitJson.put(PHONE_SUBMIT,phone);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
        String seqId=dateFormat.format(new Date())+SEQID_INT;
        String sign = DigestUtil.md5Hex(seqId + DigestUtil.md5Hex(password));

        JSONObject params = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(submitJson);
        params.put(USERID_PARAM,paramUserId);
        params.put(SEQID_PARAM,seqId);
        params.put(SIGN_PARAM,sign);
        params.put(SUBMIT_PARAM,jsonArray);

        JSONObject jsonObject = new JSONObject();
        String id= UUID.randomUUID().toString();
        jsonObject.put(ID,id);
        jsonObject.put(METHOD,SEND);
        jsonObject.put(PARAMS,params);
        logger.info("McwxSmsUtil:generateSms 成功,  手机号为{}, 请求id为{}.", phone, id);
        return jsonObject.toJSONString();
    }

    /**
     * 发送内容文案短信
     * @param jsonObject
     * @param phone
     * @return
     */
    private boolean sendSms(String jsonObject,String phone){
        CloseableHttpClient http = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-type", "application/json; charset=utf-8");
        httpPost.setHeader("Accept", "application/json");
        httpPost.setEntity(new StringEntity(jsonObject,"utf-8"));
        try {
            HttpResponse execute = http.execute(httpPost);
            if (OK_HTTP_STATUS_CODE==execute.getStatusLine().getStatusCode()){
                logger.info("McwxSmsUtil:sendSms 发送短信请求成功, code=200, 手机号为{}, 内容为{}.", phone, jsonObject);
                JSONObject responseJson = JSONObject.parseObject(EntityUtils.toString(execute.getEntity()));
                JSONArray jsonArray = responseJson.getJSONArray(RESULT_RESPONSE);
                if (jsonArray.size()<=0){
                    logger.error("McwxSmsUtil:sendSms 获取result数组为空,获取不到返回码及描述.");
                    return false;
                }
                JSONObject resultJson = jsonArray.getJSONObject(0);
                logger.info("McwxSmsUtil:sendSms 返回状态码 returnCode = {}, 描述 info = {}.", resultJson.get(RETURN_RESPONSE), resultJson.get(INFO_RESPONSE));
                if (OK_SMS_CODE == Integer.valueOf(resultJson.getString(RETURN_RESPONSE))){
                    return true;
                }
                return false;
            }else {
                logger.error("McwxSmsUtil:sendSms  发送短信请求失败,code!=200, 手机号为{}, 内容为{}.", phone, jsonObject);
            }
        } catch (IOException e) {
            logger.error("McwxSmsUtil:sendSms Mcwx发送短信验证码IO异常:{}", e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}
