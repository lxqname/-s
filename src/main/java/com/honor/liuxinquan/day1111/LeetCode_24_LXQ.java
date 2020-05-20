package com.honor.liuxinquan.day1111;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class LeetCode_24_LXQ {
    public static void main(String[] args) {

    }

    /**
     * 递归方法
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        ListNode next=head.next;
        head.next=swapPairs(next.next);
        next.next=head;
        return next;
    }

    /**
     * 非递归的方法
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head){
        ListNode pre = new ListNode(0);
        pre.next=head;
        ListNode temp=pre;
        while (temp.next!=null&&temp.next.next!=null){
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next=end;
            start.next=end.next;
            end.next=start;
            temp=start;
        }
        return pre.next;
    }

    public ListNode test1(ListNode head){
        ListNode pre = new ListNode(0);
        pre.next=head;
        ListNode temp=pre;
        while (temp.next!=null&&temp.next.next!=null){
            ListNode start=temp.next;
            ListNode end=temp.next.next;
            temp.next=end;
            start.next=end.next;
            end.next=start;
            temp=start;
        }
        return pre.next;
    }
}


/**
 * 链表
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}