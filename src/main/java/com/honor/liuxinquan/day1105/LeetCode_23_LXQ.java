package com.honor.liuxinquan.day1105;

/**
 * 执行用时 : 2.4 ms , 在所有 java 提交中击败了 100.00% 的用户 内存消耗 : 41.2 MB ,
 * 在所有 java 提交中击败了 80.22% 的用户
 *
 * 分而治之的思想
 */
public class LeetCode_23_LXQ {

    public ListNode mergeKLists(ListNode[] lists) {
    if(lists.length == 0) {
        return null;
    }
    return startMergeKLists(lists, 0, lists.length - 1);
  }
    public ListNode startMergeKLists(ListNode[] lists, int left, int right){
        if(left == right) {
            return lists[left];
        }
        int mid = (left + right) / 2;
        ListNode l1 = startMergeKLists(lists, left, mid);
        ListNode l2 = startMergeKLists(lists, mid + 1, right);
        return mergeLists(l1, l2);
    }

    public ListNode mergeLists(ListNode l1, ListNode l2){
        ListNode l3 = new ListNode(-1);
        ListNode temp = l3;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 != null ? l1 : l2;
        return l3.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

