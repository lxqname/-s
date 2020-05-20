package com.honor.week21;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week21
 * @Description:
 * @date: 2019/11/1 17:17
 */
public class LeetCode_25_LG {

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode listNode = reverseKGroup(l1, 2);
        System.out.println("LuoGuang:LeetCode_25_LG.main():");
    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 36.8 MB
     * , 在所有 java 提交中击败了
     * 95.89%
     * 的用户
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null){
            return head;
        }
        ListNode listNode = head;
        for (int i = 0;i < k-1;i++){
            listNode = listNode.next;
            if (listNode == null){
                return head;
            }
        }
        ListNode t = reverseKGroup(listNode.next, k);
        ListNode before;
        for (int i = 0; i < k; i++){
            before = head;
            head = head.next;
            before.next = t;
            t = before;
        }

        return listNode;
    }


    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
