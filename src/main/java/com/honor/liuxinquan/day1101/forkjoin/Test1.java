package com.honor.liuxinquan.day1101.forkjoin;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.csv.*;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 简单多线程将文件的内容（10000条数据）插入数据库
 *    完成时间：，表面上2s，实际大约3分钟
 *    多线程导致时间统计有误：将任务分配给各线程后，继续执行下面代码，导致结果有误，
 *                          其实只是把任务分配完了，但没有执行完。
 */
public class Test1 {
    public static void main(String[] args) {
        //在多线程中使用原子性的类
        AtomicInteger atomicInteger = new AtomicInteger();
        //定义线程
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        long start = System.nanoTime();
        Connection connection = getConnection();
        String sql="insert into ec_coupon_unique_code_copy1 (id,coupon_id,unique_code,lock_status) values ('%s','%s','%s','%s')";
        CsvReadConfig csvReadConfig = new CsvReadConfig();
        //设置是否首行做为标题行，默认false
        csvReadConfig.setContainsHeader(true);
        //设置是否跳过空白行，默认true
        csvReadConfig.setSkipEmptyRows(true);
        List<String> sqllist = CsvUtil.getReader(csvReadConfig)
                .read(FileUtil.file("C:\\java入职-代码\\it-s-my-honor1\\src\\main\\java\\com\\honor\\liuxinquan\\day1101\\forkjoin\\code.csv"))
                .getRows()
                .parallelStream()
                .map(t -> t.getByName("coupon_code"))
                .map(t -> String.format(sql, UUID.randomUUID().toString(), "lxq", "lxq_" + t, "0"))
                .collect(Collectors.toList());
        sqllist.parallelStream().forEach(t->{
            executorService.submit(()->{
                try {
                    PreparedStatement ps = connection.prepareStatement(t);
                    ps.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                long time=System.nanoTime()-start;
                double ts=time/(1e9);
                int i=atomicInteger.incrementAndGet();
                System.out.println(Thread.currentThread().getName()+i+"速度为"+(i/ts));
            });
        });
        long end=System.nanoTime();
        System.out.println((double) (end-start)/(1e9));
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                connection=DriverManager.getConnection("jdbc:mysql://203.195.136.11:3306/dev_tt_equity_center?useUnicode=true&allowMultiQueries=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8","root","cdpwy123");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 根据文件路径获取csv文件里面的内容，返回集合
     * @param path
     * @return
     */
    public static List<String> getFileContent(String path){
        CsvReadConfig csvReadConfig = new CsvReadConfig();
        //设置是否首行做为标题行，默认false
        csvReadConfig.setContainsHeader(true);
        //设置是否跳过空白行，默认true
        csvReadConfig.setSkipEmptyRows(true);
        return CsvUtil.getReader(csvReadConfig)
                .read(FileUtil.file(path))
                .getRows()
                .parallelStream()
                //获取标题对应的字段内容
                .map(t->t.getByName("coupon_code"))
                .collect(Collectors.toList());
    }
}
