package com.leetcode;

/**
 * Created by mengtian on 2017/12/21
 * <p>
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 */
public class SwapPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(100);
        head.next.next.next = new ListNode(-10);
        System.out.println(new SwapPairs().swapPairs(head));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

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
}
