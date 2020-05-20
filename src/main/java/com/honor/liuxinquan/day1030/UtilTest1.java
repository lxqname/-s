package com.honor.liuxinquan.day1030;


import org.apache.commons.lang.StringUtils;

public class UtilTest1 {
    //创建对象
    private static UtilTest1 utilTest1;

    //让构造方法私有化，不能实例化
    private UtilTest1(){};

    //获取唯一可用对象
    public static UtilTest1 getUtilTest1(){
        if (utilTest1==null){
            utilTest1=new UtilTest1();
        }
        return utilTest1;
    }

    //解题方法
    public  String getResult(String s){
        String result="";
        if (StringUtils.isBlank(s)){
            return "为空";
        }else if (s.contains(" ")){
            return "不要有空格";
        }else {
            int length=s.length();
            int count=0;
            for (int i=1;i<=length;i++){
                String[] strings = s.split(s.substring(0, i));
                if (strings.length==0){
                    count=i;
                    break;
                }
            }
            result=length/count+s.substring(0,count);
        }
        return result;
    }
}
