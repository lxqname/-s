package com.honor.liuxinquan.day1030;

import java.io.*;

/**
 * 将file1复制到file2
 */
public class Test12 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("D:\\FILE");
        File file2 = new File("E:\\FILE");
        copy(file1,file2);
    }

    private static void copy(File file1, File file2) throws IOException {
        File[] files = file1.listFiles();
        for (File f:files) {
            if (f.isFile()){
                if (!file2.exists()){
                    file2.mkdirs();
                }
                FileInputStream fileInputStream = new FileInputStream(f);
                FileOutputStream fileOutputStream = new FileOutputStream(new File(file2, f.getName()));
                byte[] bytes = new byte[1024];
                int len;
                while ((len=fileInputStream.read(bytes))!=-1){
                    fileOutputStream.write(bytes,0,len);
                }
            }else {
                copy(file1,new File(file2,f.getName()));
            }
        }
    }
}
