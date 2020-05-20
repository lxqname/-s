package com.honor.week13;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week13
 * @Description:
 * @date: 2019/9/7 15:33
 */
public class LeetCode_15_LG {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
        System.out.println(threeSum2(nums));
    }

    /**
     * 正确，超出时间限制g
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> sum = new ArrayList<>();
                        sum.add(nums[i]);
                        sum.add(nums[j]);
                        sum.add(nums[k]);
                        if (nums[i] <= nums[j] && nums[j] <= nums[k]) {
                            String key = nums[i] + "" + nums[j] + nums[k];
                            if (!map.containsKey(key)) {
                                result.add(sum);
                                map.put(key, key);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 执行用时 :
     * 66 ms
     * , 在所有 Java 提交中击败了
     * 74.25%
     * 的用户
     * 内存消耗 :
     * 56.3 MB
     * , 在所有 Java 提交中击败了
     * 67.39%
     * 的用户
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> sumList = new ArrayList<>();
                    sumList.add(nums[i]);
                    sumList.add(nums[left]);
                    sumList.add(nums[right]);

                    result.add(sumList);
                    while (right > 0 && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (left < length - 1 && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    right--;
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
