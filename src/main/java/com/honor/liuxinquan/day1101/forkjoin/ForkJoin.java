package com.honor.liuxinquan.day1101.forkjoin;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.csv.CsvReadConfig;
import cn.hutool.core.text.csv.CsvUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;

/**
 * 将文件的内容（10000条数据）插入数据库
 * forkJoin思想：
 *      继承RecursiveAction，大任务分为小任务
 *      完成时间为3秒左右
 *
 *      核心思想:
 *      将一个大任务拆分成多个小任务后，
 *      使用fork可以将小任务分发给其他线程同时处理，
 *      使用join可以将多个线程处理的结果进行汇总；
 *      这实际上就是分治思想的并行版本。
 *
 */
public class ForkJoin extends RecursiveAction {

    List<String>code;
    Connection connection;
    int maxNumber=200;

    public ForkJoin(List<String> code, Connection connection) {
        this.code = code;
        this.connection = connection;
    }

    public static void main(String[] args) {
        long start=System.nanoTime();
        List<String> list = getCode("C:\\java入职-代码\\it-s-my-honor1\\src\\main\\java\\com\\honor\\liuxinquan\\day1101\\forkjoin\\code.csv");
        ForkJoin forkJoin = new ForkJoin(list, getConnection());
        ForkJoinPool forkJoinPool = new ForkJoinPool(20);
        ForkJoinTask forkJoinTask = forkJoinPool.submit(forkJoin);
        forkJoinTask.join();
        long end=System.nanoTime();
        System.out.println((double)(end-start)/1e9);
    }


    @Override
    protected void compute() {
        if (code.size()<=maxNumber){
            goRun();
        }else {
            //每次任务分配200
            ForkJoin a = new ForkJoin(code.subList(0, maxNumber), this.connection);
            ForkJoin b = new ForkJoin(code.subList(maxNumber, code.size()), this.connection);
            //提交任务
            invokeAll(a,b);
        }
    }

    public void goRun() {
        String sqlPrefix="insert into ec_coupon_unique_code_copy1 (id,coupon_id,unique_code,lock_status) values ";
        String sqlSuffix="('%s','%s','%s','%s')";
        String values = code.parallelStream()
                .map(t -> String.format(sqlSuffix, UUID.randomUUID().toString(), "lxq", "lxq_" + t, "0"))
                .collect(Collectors.joining(","));
        String sql=sqlPrefix+values;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
                connection= DriverManager.getConnection("jdbc:mysql://203.195.136.11:3306/dev_tt_equity_center?useUnicode=true&allowMultiQueries=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8","root","cdpwy123");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 从csv文件中返回内容集合
     * @param path
     * @return
     */
    public static List<String> getCode(String path){
        CsvReadConfig csvReadConfig = new CsvReadConfig();
        csvReadConfig.setContainsHeader(true);
        csvReadConfig.setSkipEmptyRows(true);
        return CsvUtil.getReader(csvReadConfig)
                .read(FileUtil.file(path))
                .getRows()
                .parallelStream()
                .map(t->t.get(0))
                .collect(Collectors.toList());
    }
}
