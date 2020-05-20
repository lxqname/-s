package com.honor.week2;

/**
 * 274. H指数
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
 * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的（N 篇论文中）至多有h篇论文分别被引用了至少h次。
 * （其余的 N - h 篇论文每篇被引用次数不多于 h 次。）”
 *
 * @author 傅国俊
 */
public class LeetCode_274_FGJ {

    public static void main(String[] args) {
        int[] citations = new int[]{3, 0, 6, 1, 5};
        System.out.println(LeetCode_274_FGJ.hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        int response = 0;
        for (; response <= citations.length; response++) {
            int temp = 0;
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= response) {
                    temp = temp + 1;
                    if (temp > response) {
                        break;
                    }
                }
            }
            if (temp < response) {
                break;
            }
        }
        return response - 1;
    }

    /**
     * 用时最短题解
     * 执行用时 : 1 ms , 在所有Java提交中击败了 100.00% 的用户
     * 内存消耗 : 34.6 MB , 在所有Java提交中击败了 91.45% 的用户
     *
     * 用一个数组记录每个引用次数的次数，因为h指数最大不超过论文总数，所以凡是大于论文总数的引用次数都记录在论文总数上
     * @return int
     */
    public int hIndexFromFastestSolution(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];
        for (int citation : citations) {
            if (citation > n) {
                buckets[n]++;
            } else {
                buckets[citation]++;
            }
        }
        int count = 0;
        for (int i = n; i > 0; i--) {
            count += buckets[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }
}
