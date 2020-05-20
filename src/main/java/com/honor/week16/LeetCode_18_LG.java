package com.honor.week16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week16
 * @Description:
 * @date: 2019/9/26 20:50
 */
public class LeetCode_18_LG {

    public static void main(String[] args){
        int[] nums = new int[]{-3,-2,-1,0,0,1,2,3};
        int target = 0;
        System.out.println(fourSum(nums, target));

    }

    /**
     * 输入:
     * [-3,-2,-1,0,0,1,2,3]
     * 0
     * 输出
     * [[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,0,0,2],[-1,0,0,1]]
     * 预期结果
     * [[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     * LeetCode 出问题了 [-2,-1,1,2] 是其中一个解
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++){
            for (int j = i+1; j < nums.length-2; j++){
                int L = j+1;
                int R = nums.length-1;
                while (L < R){
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if (sum > target){
                        int rValue = nums[R];
                        R--;
                        while (rValue == nums[R] && R > L){
                            R--;
                        }
                    }else if(sum < target){
                        int lValue = nums[L];
                        L++;
                        while (lValue == nums[L] && L < R){
                            L++;
                        }
                    }else {
                        result.add(Arrays.asList(nums[i],nums[j],nums[L],nums[R]));
                        break;
                    }
                }
            }
        }
        return result;
    }

}
