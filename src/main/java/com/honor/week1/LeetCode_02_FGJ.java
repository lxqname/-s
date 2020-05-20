package com.honor.week1;

import java.util.ArrayList;
import java.util.List;

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * @author 傅国俊
 */
public class LeetCode_02_FGJ {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = LeetCode_02_FGJ.addTwoNumbers(l1, l2);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<ListNode> list = new ArrayList<>();
        // 进位
        int carry = 0;
        while (true) {
            if (l1 == null && l2 == null && carry == 0) {
                for (int i = 0; i < list.size() - 1; i++) {
                    list.get(i).next = list.get(i + 1);
                }
                return list.get(0);
            } else {
                int v1 = 0;
                int v2 = 0;
                if (l1 != null) {
                    v1 = l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    v2 = l2.val;
                    l2 = l2.next;
                }
                int sum = v1 + v2 + carry;
                if (sum > 9) {
                    carry = 1;
                    sum = sum % 10;
                } else {
                    carry = 0;
                }
                list.add(new ListNode(sum));
            }
        }
    }

    /**
     * 官方题解（有趣之处在于使用一个哑结点）
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return ListNode
     */
    public static ListNode addTwoNumbersFromOfficialSolution(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}



