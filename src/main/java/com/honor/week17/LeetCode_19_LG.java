package com.honor.week17;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week17
 * @Description:
 * @date: 2019/10/5 21:57
 */
public class LeetCode_19_LG {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l3.next = l4;
        l2.next = l3;
        l1.next = l2;
        System.out.println("LuoGuang:LeetCode_19_LG.main():"+l1);
        System.out.println(removeNthFromEnd2(l1,1));
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 91.65%
     * 的用户
     * 内存消耗 :
     * 34.6 MB
     * , 在所有 Java 提交中击败了
     * 87.53%
     * 的用户
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode countNode = first;
        int count = 0;
        while (countNode != null){
            count ++;
            countNode = countNode.next;
        }
        int index = count - n;

        ListNode tempNode = first;
        while (index > 1){
            index --;
            tempNode = tempNode.next;
        }
        tempNode.next = tempNode.next.next;
        return first.next;
    }


    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 34.5 MB
     * , 在所有 Java 提交中击败了
     * 88.37%
     * 的用户
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode rightNode = first;
        while (n > 0){
            rightNode = rightNode.next;
            n--;
        }
        ListNode leftNode = first;
        while (rightNode.next != null){
            rightNode = rightNode.next;
            leftNode = leftNode.next;
        }
        leftNode.next = leftNode.next.next;
        return first.next;
    }

}
