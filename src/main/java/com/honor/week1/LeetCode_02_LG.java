package com.honor.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week1
 * @Description: 两数相加
 * @date: 2019/6/3 21:20
 */
public class LeetCode_02_LG {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r = new ListNode(0);
        ListNode p = l1; ListNode q = l2;
        ListNode node = r;
        int tag = 0;
        while(p != null || q != null){
            int count = (p == null?0:p.val) + (q == null?0:q.val);
            count = count+tag;
            if(count >= 10){
                count = count - 10;
                tag = 1;
            }else{
                tag = 0;
            }
            ListNode next = new ListNode(count);
            node.next = next;
            node = node.next;

            p = p == null?null:p.next;
            q = q == null?null:q.next;

            if(p == null && q == null && tag > 0){
                ListNode result = new ListNode(1);
                node.next = result;
            }
        }


        return r.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}

