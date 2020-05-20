package com.honor.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week1
 * @Description: 两数之和
 * @date: 2019/6/3 21:20
 */
public class LeetCode_01_LG {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        for (int r:
             result) {
            System.out.println(r);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }

        for(int i = 0; i < nums.length; i++){
            int num = target - nums[i];
            if(map.containsKey(num) && i != map.get(num)){
                return new int[]{i, map.get(num)};
            }
        }
        return null;
    }
}

