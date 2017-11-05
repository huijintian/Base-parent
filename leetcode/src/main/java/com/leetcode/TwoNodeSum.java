package com.leetcode;

/**
 * Created by mengtian on 2017/11/2
 * <p>
 * https://leetcode.com/problems/add-two-numbers/
 */
public class TwoNodeSum {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(3);

        ListNode node = addTwoNumbers(l1, l2);
        System.out.println(node);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            cur.val = val % 10;
            carry = val / 10;

            //!!!关键的地方 此时prev指向head, head.next -> cur
            prev.next = cur;
            // 将prev往前移一步 head->cur(head.next)(prev)
            //下次进入循环时，prev指向的是cur
            prev = cur;

            l1 = l1 == null ? null : (l1.next == null ? null : l1.next);
            l2 = l2 == null ? null : (l2.next == null ? null : l2.next);
        }

        return head.next;
    }
}

