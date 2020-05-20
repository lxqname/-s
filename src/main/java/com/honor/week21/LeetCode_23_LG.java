package com.honor.week21;

import java.util.*;

/**
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week21
 * @Description:
 * @date: 2019/10/30 19:21
 */
public class LeetCode_23_LG {

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode node = mergeKLists(new ListNode[]{l1, l2, l3});
        ListNode node2 = mergeKLists2(new ListNode[]{l1, l2, l3});
        System.out.println("LuoGuang:LeetCode_23_LG.main():");
    }


    /**
     * 执行用时 :
     * 15 ms
     * , 在所有 java 提交中击败了
     * 49.29%
     * 的用户
     * 内存消耗 :
     * 44 MB
     * , 在所有 java 提交中击败了
     * 56.49%
     * 的用户
     * @param lists
     * @return
     */
    public static ListNode mergeKLists2(ListNode[] lists) {
        ListNode node = new ListNode(-1);
        List<Integer> minList = new ArrayList<>();

        for (int i = 0; i < lists.length; i++){
            ListNode n = lists[i];
            while (n != null){
                minList.add(n.val);
                n = n.next;
            }
        }
        Collections.sort(minList);
        ListNode tmp = node;

        for (Integer m: minList){
            tmp.next = new ListNode(m);
            tmp = tmp.next;
        }

        return node.next;
    }

    /**
     * 执行用时 :
     * 603 ms
     * , 在所有 java 提交中击败了
     * 5.01%
     * 的用户
     * 内存消耗 :
     * 59.9 MB
     * , 在所有 java 提交中击败了
     * 8.40%
     * 的用户
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode node = new ListNode(-1);
        List<Integer> minList = new ArrayList<>();

        for (int i = 0; i < lists.length; i++){
            ListNode n = lists[i];
            if (n!=null){
                minList.add(n.val);
            }
        }
        Collections.sort(minList);
        addMinNode(node, lists, minList);

        return node.next;
    }

    private static void addMinNode(ListNode node, ListNode[] lists, List<Integer> minList) {
        if (minList.size() == 0){
            return;
        }
        for (int i = 0; i < lists.length; i++){
            Integer integer = minList.get(0);
            ListNode n = lists[i];
            if (n != null && n.val<=integer){
                node.next = new ListNode(n.val);
                node = node.next;
                minList.remove(0);
                if (n.next != null){
                    minList.add(n.next.val);
                    lists[i] = n.next;
                }else {
                    lists[i] = null;
                }
                Collections.sort(minList);
                addMinNode(node,lists,minList);
                return;
            }
        }
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
