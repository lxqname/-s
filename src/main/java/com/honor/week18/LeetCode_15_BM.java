package com.honor.week18;

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
 * [-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]
 * 预期：
 * [[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]
 *
 * @Author: 白猛
 * @Date: 2019/9/30 10:58
 */
public class LeetCode_15_BM {

    public static void main(String[] args) {
        int[] nums = new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        System.out.println(threeSum(nums));
        System.out.println(three(nums));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int a = 0;
        int b = 0;
        int c = 0;
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    a = nums[i];
                    b = nums[j];
                    c = nums[k];
                    if (a + b + c == 0) {
                        int sumOfSquare = a * a + b * b + c * c;
                        s1 = String.valueOf(sumOfSquare);
                        int product = a * b * c;
                        s2 = String.valueOf(product);

                        if (set.add(s1 + s2)) {
                            List<Integer> ints = new ArrayList<>();
                            ints.add(a);
                            ints.add(b);
                            ints.add(c);
                            result.add(ints);
                        }


                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> three(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        int l = 0;
        int r = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            l = i + 1;
            r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[l]);
                    integers.add(nums[r]);
                    result.add(integers);
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }

}
