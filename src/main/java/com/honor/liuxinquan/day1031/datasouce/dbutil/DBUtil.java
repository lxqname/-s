package com.honor.liuxinquan.day1031.datasouce.dbutil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * 自定义jdbc连接
 */
public class DBUtil {
    private static String className = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

    static {
        Properties properties = new Properties();
        try {
            //通过类加载器调用getResourceAsStream（）来加载文件
            properties.load(DBUtil.class.getClassLoader().getResourceAsStream("com/honor/liuxinquan/day1031/datasouce/dbutil/jdbc.properties"));
            className = properties.getProperty("className");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            //加载驱动
            Class.forName(className);
            //获取连接对象
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
