package com.honor.liuxinquan.day1030;

import java.io.File;


public class Test11 {
    public static void main(String[] args) {
        File file = new File("D:\\");
        select1(file);
        delect(file);
    }

    /**
     * 删除d盘目录下的文件(递归)
     * @param file
     */
    private static void delect(File file) {
        File[] files = file.listFiles();
        for (File f:files){
            if (f.isFile()){
                f.delete();
            } else {
                delect(f);
            }
        }
    }

    /**
     * 找出D目录下的所有文件名(递归)
     */
    private static void select1(File file) {
        File[] files = file.listFiles();
        for (File f:files){
            if (f.isFile()){
                System.out.println(f.getName());
            } else {
              select1(f);
            }
        }
    }
}
