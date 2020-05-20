package com.honor.week2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
 *
 * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）至多有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）”
 *
 * 示例:
 *
 * 输入: citations = [3,0,6,1,5]
 * 输出: 3
 * 解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 *      由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。
 *
 * 说明: 如果 h 有多种可能的值，h 指数是其中最大的那个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/h-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week2
 * @Description:
 * @date: 2019/6/14 23:26
 */
public class LeetCode_274_LG {

    public static void main(String[] args){
        int[] citations = new int[]{0,1,1};
        System.out.println(hIndex(citations));
    }

    /**
     * 执行用时 :56 ms, 在所有Java提交中击败了5.62%的用户
     * 内存消耗 :36.1 MB, 在所有Java提交中击败了80.92%的用户
     * @param citations
     * @return
     */
    public static int hIndex(int[] citations) {
        if (citations.length == 0) {return 0;}

        int maxNum = 0;
        for (int i = 0;i < citations.length; i++) {
            if (citations[i] > maxNum){
                maxNum = citations[i];
            }
        }

        int result = 0;
        int tag = 0;
        Map<Integer, Integer> countMap = new HashMap<>(citations.length);
        for (int i = 0;i < citations.length; i++){
            tag = citations[i];
            if (countMap.containsKey(tag)){
                countMap.put(tag, countMap.get(tag)+1);
            }else{
                countMap.put(tag, 1);
            }

        }
        if (countMap.size() == 1){
            if(countMap.get(tag) > 1){
                return tag;
            }
            return tag == 0?0:1;
        }

        for (int i =0; i <= maxNum;i++){
            int count = 0;
            for (Map.Entry<Integer, Integer> entry: countMap.entrySet()){
                if (entry.getKey() >= i){
                    count += entry.getValue();

                }
            }

            if (count > result){
                result = i;
            }

        }



        return result;
    }
}
