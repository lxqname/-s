package com.honor.liuxinquan.day1108;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;


public class ProUtil {
    private static final Logger logger = LoggerFactory.getLogger(ProUtil.class);

    private static Properties properties = new Properties();

    private static boolean isFirst = true;
/*

    */
/**
     * 加载接口
     * @return
     *//*

    public static Properties loadProperties(){
        //String path = "src" + File.separator + "property.properties";
        InputStream inputStream = ProUtil.class.getResourceAsStream("/property.properties");
        Properties properties = new Properties();
        //InputStream imputStream = ProUtil.class.getClassLoader().getResourceAsStream(path);
        try {
            //InputStream inputStr = new BufferedInputStream(new FileInputStream(path));
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            BufferedReader reader = new BufferedReader(new InputStreamReader(bis, "UTF-8"));
            properties.load(reader);
            bis.close();
            reader.close();
        } catch (IOException e) {
            logger.info("加载.properties文件失败！"+e.getMessage());
            e.printStackTrace();
        }
        return properties;
    }

    public static String getProValue(String properName){
        if("".equals(properName) || null == properName){
            return null;
        }
        Properties propertes = ProUtil.loadProperties();
        return propertes.getProperty(properName);
    }

*/

    public static String getProValue(String properName){
        if("".equals(properName) || null == properName){
            return null;
        }
        if (isFirst){
            properties = ProUtil.loadProperties();
            isFirst = false;
        }
        return properties.getProperty(properName);
    }

    public static void setProValue(String key,String value,String comment){
        if("".equals(key) || null == key){
            return ;
        }
        properties.setProperty(key,value);
    }

    public static Properties loadProperties(){
        //String path = "src" + File.separator + "property.properties";
        //InputStream inputStream = ProUtil.class.getResourceAsStream("/property.properties");
        //Properties properties = new Properties();
        //InputStream imputStream = ProUtil.class.getClassLoader().getResourceAsStream(path);
        BufferedInputStream bis = null;
        BufferedReader reader = null;
        InputStream inputStr = null;
        try {
            inputStr = new BufferedInputStream(new FileInputStream(UtilPath.getClassPath() + "/property.properties"));
            bis = new BufferedInputStream(inputStr);
            reader = new BufferedReader(new InputStreamReader(bis, "UTF-8"));
            properties.load(reader);

        } catch (IOException e) {
            logger.info("加载.properties文件失败！" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                bis.close();
                reader.close();
                inputStr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

    public static JSONObject getAllProValue() {
        if (isFirst){
            properties = ProUtil.loadProperties();
            isFirst = false;
        }
        JSONObject jsonObject = new JSONObject();
        Enumeration enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()){
            String key = (String) enumeration.nextElement();
            jsonObject.put(key.toString(),properties.getProperty(key));
        }
        return jsonObject;
    }

	/*public static void main(String[] args) {
		System.out.println(ProUtil.getProValue("Url.HANGZHOU_ARTICLE"));
	}*/
}
