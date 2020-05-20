package com.honor.liuxinquan.day1030;

import java.io.File;
import java.io.FileFilter;

/**
 * 文件方法类
 */
public class Test10 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        //1.文件的绝对路径
        String absolutePath = file.getAbsolutePath();
        //2.文件的相对路径
        String path = file.getPath();
        //3.文件名
        String name = file.getName();
        //4.文件是否可读,写
        boolean b = file.canRead();
        boolean c = file.canWrite();
    }

    /**
     * 求目录下txt文件
     */
    public void test1(){
        File file = new File("D:");
        File[] txts = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isFile()) {
                    if (pathname.getName().endsWith("txt")) {
                        return true;
                    }
                }
                return false;
            }
        });
        for (File c:txts) {
            System.out.println(c.getName());
        }
    }
}
