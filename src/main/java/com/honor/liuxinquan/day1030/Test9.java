package com.honor.liuxinquan.day1030;

import cn.hutool.core.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

public class Test9 {
    /**
     * 根据长度切割集合
     * @param list
     * @param count
     * @param <T>
     * @return
     */
    public static <T>List<List<T>> spilList(List<T> list,int count){
        if (ObjectUtil.isNull(list) ||count<1){
            return null;
        }
        List<List<T>> result = new ArrayList<>();
        int size = list.size();
        if (size<=count){
            result.add(list);
        }else {
            int a=size/count;
            int end=size%count;
            for (int i=0;i<a;i++){
                List<T> objects = new ArrayList<T>();
                for (int j=0;j<count;j++){
                    objects.add(list.get(i*count+j));
                }
                result.add(objects);
            }
            if (end>0){
                List<T> objects = new ArrayList<T>();
                for (int z=0;z<end;z++){
                    objects.add(list.get(a*count+z));
                }
                result.add(objects);
            }
        }
        return result;
    }
}
