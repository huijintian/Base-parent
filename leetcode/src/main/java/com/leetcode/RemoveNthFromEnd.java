package com.leetcode;

/**
 * Created by mengtian on 2017/12/11
 * <p>
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */
public class RemoveNthFromEnd {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "val:" + val + " ->next:" + next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        /*listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);*/
        System.out.println(new RemoveNthFromEnd().removeNthFromEnd(listNode, 1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        ListNode runner = newHead;
        while (n > 0) {
            runner = runner.next;
            n--;
        }
        while (runner.next != null) {
            runner = runner.next;
            p = p.next;
        }
        p.next = p.next.next;
        return newHead.next;
    }
}

