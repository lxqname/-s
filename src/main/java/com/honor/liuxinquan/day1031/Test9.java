package com.honor.liuxinquan.day1031;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * 通过httpclient模拟创建一个http的get请求
 */
public class Test9 {
    public static void main(String[] args) {
        sendHttpByGet();
    }

    private static void sendHttpByGet() {
        //创建httpclient客户端
        CloseableHttpClient aDefault = HttpClients.createDefault();
        //创建httpGet请求
        String url = "http://www.baidu.com";
        //创建get请求
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse httpResponse = null;
        try {
            //发起请求，得到响应
            httpResponse = aDefault.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Header[] allHeaders = httpResponse.getAllHeaders();
        for (Header h : allHeaders) {
            System.out.println(h.getName() + "" + h.getValue() + "====");
        }
        HttpEntity entity = httpResponse.getEntity();
        System.out.println(entity);
        System.out.println(httpResponse.getLocale());
        System.out.println(httpResponse.getStatusLine());
        //关闭客户端
        if (aDefault != null) {
            try {
                aDefault.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (httpResponse != null) {
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
