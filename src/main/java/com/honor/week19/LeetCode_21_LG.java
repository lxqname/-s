package com.honor.week19;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week19
 * @Description:
 * @date: 2019/10/20 15:05
 */
public class LeetCode_21_LG {
    
    public static void main(String[] args){  
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;


        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;

        System.out.println("LuoGuang:LeetCode_21_LG.main():"+mergeTwoLists(l1,l4));
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 java 提交中击败了
     * 94.07%
     * 的用户
     * 内存消耗 :
     * 36 MB
     * , 在所有 java 提交中击败了
     * 87.52%
     * 的用户
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergeNode = new ListNode(-1);
        ListNode temp = mergeNode;
        while (l1 != null || l2 != null){
            if (l1 == null && l2 != null){
                temp.next = l2;
                break;
            }

            if (l1 != null && l2 == null){
                temp.next = l1;
                break;
            }

            if (l1.val <= l2.val){
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            temp = temp.next;
        }

        return mergeNode.next;
    }

    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
}
