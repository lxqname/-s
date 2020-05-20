package com.honor.week14;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week14
 * @Description:
 * @date: 2019/9/10 18:55
 */
public class LeetCode_16_LG {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        int[] nums2 = new int[]{2,3,5,1,-3,-10};
        int[] nums3 = new int[]{1,1,1,0};
        int[] nums4 = new int[]{1,1,-1,-1,3};
        System.out.println(threeSumClosest(nums, 1));
        System.out.println(threeSumClosest(nums2, 5));
        System.out.println(threeSumClosest(nums3, -100));
        System.out.println(threeSumClosest(nums4, -1));
    }

    /**
     * 执行用时 :
     * 18 ms
     * , 在所有 Java 提交中击败了
     * 34.68%
     * 的用户
     * 内存消耗 :
     * 36 MB
     * , 在所有 Java 提交中击败了
     * 84.68%
     * 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {

        int len = nums.length;
        if (len == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        if (len < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int resultCount = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len-2; i++) {
            int left = i + 1;
            int right = len-1;


            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(resultCount - target)) {
                    resultCount = sum;
                }
                if (resultCount > target){
                    right--;
                }else if (resultCount < target){
                    left++;
                }else {
                    return resultCount;
                }

            }
        }

        return resultCount;
    }


}