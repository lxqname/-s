package com.honor.week14;

import java.util.Arrays;

/**
 * @author liuxinquan
 */
public class LeetCode_16_LXQ {

    public static void main(String[] args) {
        int [] nums={5,6,7,4,8,9,3};
        int target=20;
        int i = threeSumClosest(nums, target);
        System.out.println(i);
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int a = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length;i++) {
            int min = i+1, max = nums.length - 1;
            while(min < max) {
                int sum = nums[min] + nums[max] + nums[i];
                if(Math.abs(target - sum) < Math.abs(target - a))
                    a = sum;
                if(sum > target)
                    max--;
                else if(sum < target)
                    min++;
                else
                    return a;
            }
        }
        return a;
    }
}
