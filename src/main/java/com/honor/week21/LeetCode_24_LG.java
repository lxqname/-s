package com.honor.week21;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week21
 * @Description:
 * @date: 2019/10/31 18:09
 */
public class LeetCode_24_LG {

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        ListNode node = swapPairs(l1);
        System.out.println("LuoGuang:LeetCode_24_LG.main():");
    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 34.8 MB
     * , 在所有 java 提交中击败了
     * 81.01%
     * 的用户
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode listNode = new ListNode(-1);
        listNode.next = head;
        head = listNode;
        while (head != null && head.next != null){
            ListNode before = head.next;
            ListNode after = head.next.next;
            if(after == null){
                break;
            }
            before.next = after.next;
            after.next = before;
            head.next = after;
            head = before;
        }

        return listNode.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
