package com.honor.week17;
//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
//示例：
//
//给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
//


/**
 * @description:
 * @program:
 * @author: LiuXinQuan
 * @mail: liuxinquan@deepexi.com
 * @date: 2019/9/30 10:33
 */
public class LeetCode_19_LXQ {
    public static void main(String[] args) {
        int n = 1;
        ListNode head = new ListNode(1);
        ListNode first = head;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(5);

        ListNode pre = new ListNode(0);
        pre.next = first;
        ListNode start = pre, end = pre;
        while (n != 0) {
            start = start.next;
            n--;
        }
        while (start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        while (pre.next != null) {
            System.out.println(pre.next.val);
            pre = pre.next;
        }

    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
