package com.honor.liuxinquan.day1031;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过httpclient模拟创建一个http的post请求
 */
public class Test10 {
    public static void main(String[] args) {
        post1();
    }

    private static void post1() {
        //创建httpclient客户端
        CloseableHttpClient aDefault = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://www.baidu.com/action?age=1&name='hh'");
        // 设置请求头
        httpPost.setHeader("connection", "keep-alive");
        // 设置代理（模拟浏览器版本）
        httpPost.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; WOW64) " +
                        "AppleWebKit/537.36 (KHTML, like Gecko) " +
                        "Chrome/63.0.3239.132 Safari/537.36");
        // 设置 Cookie
        httpPost.setHeader("Cookie", "UM_distinctid=" +
                "16442706a09352-0376059833914f-3c604504-1fa400-16442706a0b345;" +
                " CNZZDATA1262458286=1603637673-1530123020-%7C1530123020; " +
                "JSESSIONID=805587506F1594AE02DC45845A7216A4");
        // 创建 HttpPost 参数
        List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
        list.add(new BasicNameValuePair("draw", "1"));
        list.add(new BasicNameValuePair("start", "0"));
        list.add(new BasicNameValuePair("length", "10"));
        CloseableHttpResponse execute = null;
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            execute = aDefault.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity = execute.getEntity();
        try {
            System.out.println(EntityUtils.toString(entity) + "-----------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
