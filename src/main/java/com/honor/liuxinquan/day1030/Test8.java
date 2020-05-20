package com.honor.liuxinquan.day1030;

import cn.hutool.core.codec.Base64;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class Test8 {

    /**
     * MD5加密
     * @param s
     * @return
     */
    public static String getStringByMD5(String s){
        char a[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] bytes = s.getBytes("UTF-8");
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest instance = MessageDigest.getInstance("MD5");
            //使用指定的字节更新摘要
            instance.update(bytes);
            //获得密文
            byte[] digest = instance.digest();
            // 把密文转换成十六进制的字符串形式
            int length = digest.length;
            char b[]=new char[length*2];
            int c=0;
            for (int i=0;i<length;i++){
                byte c1 = digest[0];
                b[c++]=a[c1>>> 4 & 0xf];
                b[c++]=a[c1 & 0xf];
            }
            return new String(b);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * base64加密
     * @param s
     * @return
     */
    public static String base64Encode(String s){
        byte[]b=null;
        String result=null;
        try {
            b = s.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b!=null){
            result= Base64.encode(b);
        }
        return result;
    }

    /**
     * base64解密
     * @param s
     * @return
     */
    public static String base64Decode(String s){
        String result=null;
        byte[] bytes = Base64.decode(s);
        try {
            result=new String(bytes,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
