package com.honor.week19;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 执行用时 :
 * 5 ms
 * , 在所有 Java 提交中击败了
 * 99.06%
 * 的用户
 * 内存消耗 :
 * 36.3 MB
 * , 在所有 Java 提交中击败了
 * 84.18%
 * 的用户
 *
 * @Author: 白猛
 * @Date: 2019/9/30 17:16
 */
public class LeetCode_16_BM {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int l = 0;
        int r = 0;
        int distance = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            l = i + 1;
            r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
                if (Math.abs(sum - target) < distance) {
                    distance = Math.abs(sum - target);
                    result = sum;
                }
            }
        }
        return result;
    }

}
