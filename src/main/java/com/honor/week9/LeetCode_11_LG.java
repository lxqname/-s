package com.honor.week9;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week9
 * @Description:
 * @date: 2019/8/3 14:37
 */
public class LeetCode_11_LG {

    public static void main(String[] args){
        int[] height = {1,8,0,3,1,2,3,4,1,33,23,123,1,3,4,12,32,12,34};
        System.out.println(maxArea(height));
    }

    /**
     * 执行用时 :
     * 449 ms
     * , 在所有 Java 提交中击败了
     * 16.35%
     * 的用户
     * 内存消耗 :
     * 45.5 MB
     * , 在所有 Java 提交中击败了
     * 46.04%
     * 的用户
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int length = height.length;
        int max = 0;
        for(int i = 0; i < length; i++){
            for(int j = i; j<length;j++){
                int a = Math.min(height[i],height[j])*(j-i);
                max = Math.max(max,a);
            }
        }

        return max;
    }
}
