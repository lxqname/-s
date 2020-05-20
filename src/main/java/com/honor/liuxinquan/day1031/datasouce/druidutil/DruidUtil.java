package com.honor.liuxinquan.day1031.datasouce.druidutil;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * druid连接数据库
 *
 * @author 86151
 */
public class DruidUtil {

    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        try {
            properties.load(DruidUtil.class.getClassLoader().getResourceAsStream("com/honor/liuxinquan/day1031/datasouce/druidutil/druid.properties"));
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
