package com.honor.week2;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week2
 * @Description:
 * @date: 2019/6/11 20:49
 */
public class LeetCode_04_LG {

    public static void main(String[] args){
//        int[] n1 = {1,3,4,5,7,9};
//        int[] n2 = {2,3,41,123};
        int[] n1 = {3};
        int[] n2 = {2};
        System.out.println(findMedianSortedArrays(n1, n2));
    }

    /**
     * 方法一 20ms 时间复杂度未通过
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0){
            return getMedianSorted(nums2);
        }
        if (nums2 == null || nums2.length == 0){
            return getMedianSorted(nums1);
        }

        int[] allNum = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++){
            allNum[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++){
            allNum[i+nums1.length] = nums2[i];
        }
        Arrays.sort(allNum);
        return getMedianSorted(allNum);
    }

    private static double getMedianSorted(int[] nums2) {
        int num =  nums2.length%2;
        if (num == 0){
             int start =  nums2.length/2;
             int end = start;
             BigDecimal b1 = new BigDecimal(nums2[start-1]+nums2[end]);
             BigDecimal b2 = new BigDecimal(2);
             return b1.divide(b2,2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }else {
            if (nums2.length == 1){
                return nums2[0];
            }
            return nums2[nums2.length/2];

        }
    }
}
