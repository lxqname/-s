package com.honor.week4;

/**
 * 4. 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * @author 傅国俊
 */
public class LeetCode_04_FGJ {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[0];
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 寻找两个有序数组的中位数
     * 执行用时 : 12 ms , 在所有 Java 提交中击败了 84.97% 的用户
     * 内存消耗 : 52.4 MB , 在所有 Java 提交中击败了 70.63% 的用户
     *
     * @param nums1 有序数组1
     * @param nums2 有序数组2
     * @return double
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = null;
        if (null == nums1 || nums1.length == 0) {
            temp = nums2;
        }else if (null == nums2 || nums2.length == 0) {
            temp = nums1;
        }
        if (null != temp) {
            int rightIndex = temp.length / 2;
            int leftIndex = (temp.length - 1) / 2;
            return (temp[leftIndex] + temp[rightIndex]) / 2.0;
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = 0;
        for (int i = 0, a = 0, b = 0, min = 0; i <= (m + n) / 2; i++) {
            if (a < m && b < n) {
                if (nums1[a] <= nums2[b]) {
                    min = nums1[a];
                    a++;
                } else {
                    min = nums2[b];
                    b++;
                }
            } else if (a < m) {
                min = nums1[a];
                a++;
            } else {
                min = nums2[b];
                b++;
            }
            if (i == (m + n - 1) / 2) {
                left = min;
            }
            if (i == (m + n) / 2) {
                right = min;
            }
        }
        return (left + right) / 2.0;
    }
}
