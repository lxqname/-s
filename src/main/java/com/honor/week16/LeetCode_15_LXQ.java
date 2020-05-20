package com.honor.week16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * @author 86151
 */
public class LeetCode_15_LXQ {
    public static void main(String[] args) {
        int [] num={1,8,-5,-6,4};
        List<List<Integer>> resultList = new ArrayList<>();
        if (num==null||num.length<3){
            System.out.println(resultList);
        }
        Arrays.sort(num);
        for (int i=0;i<num.length;i++){
            if (num[i]>0){
                break;
            }
            if (num[i]==num[i+1]&&i<num.length-1){
                continue;
            }
            int left=i+1;
            int right=num.length-1;
            while (left<right){
                int sum=num[i]+num[left]+num[right];
                if (sum==0){
                    resultList.add(Arrays.asList(num[i],num[left],num[right]));
                    if (left<right&&left==left+1){
                        left++;
                    }
                    if (left<right&&right==right--){
                        right--;
                    }
                    left++;
                    right--;
                }else if (sum<0){
                    left++;
                }else if (sum>0){
                    right--;
                }
            }
        }
        System.out.println(resultList);
    }
}
