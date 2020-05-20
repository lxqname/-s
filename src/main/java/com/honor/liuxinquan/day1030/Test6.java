package com.honor.liuxinquan.day1030;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义反射的万能sql处理
 */
public class Test6 {

    /**
     * 万能查询sql
     *
     * @param sql
     * @param clazz
     * @param args
     * @param <T>
     * @return
     */
    public <T> List<T> queryCommon(String sql, Class<T> clazz, Object... args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                T t = clazz.newInstance();
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    String name = field.getName();
                    Object object = rs.getObject(name);
                    field.set(t, object);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs,ps,connection);
        }
        return list;
    }

    /**
     * 万能增删改方法
     *
     * @return
     */
    public Integer updateCommon(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement ps = null;
        int result = 0;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(ps,connection);
        }
        return result;
    }

    /**
     * 创建连接对象
     *
     * @return
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                connection = DriverManager.getConnection("jdbc:mysql://rm-bp16885t0yn5g56gybo.mysql.rds.aliyuncs.com:3306/test11", "root", "Deeptest2018");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 万能释放资源方法
     * @param closeAll
     */
    public static void closeAll(AutoCloseable...closeAll) {
        for (AutoCloseable c : closeAll) {
            if (c != null) {
                try {
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
