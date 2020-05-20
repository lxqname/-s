package com.honor.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * @author 傅国俊
 */
public class LeetCode_01_FGJ {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 26;
        int[] result = LeetCode_01_FGJ.twoSum(nums, target);
        for (int index : result) {
            System.out.println(index);
        }

    }

    private static int[] twoSum(int[] nums, int target) {
        // 整数，数组下标
        Map<Integer, Integer> numMap = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int match = target - nums[i];
            if (numMap.containsKey(match)) {
                return new int[]{numMap.get(match), i};
            } else {
                numMap.put(nums[i], i);
            }
        }
        throw new RuntimeException("当前数组中没有两数之和符合要求");
    }
}
