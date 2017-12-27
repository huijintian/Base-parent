package com.leetcode;

/**
 * Created by mengtian on 2017/12/26
 * <p>
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 */
public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(100);
        head.next.next.next = new ListNode(-10);
        System.out.println(new ReverseKGroup().reverseKGroup(head, 2));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) {//find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) {//if k+1 node is found
            curr = reverseKGroup(curr, k);//reserve list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) {// reverse current k-group:
                ListNode temp = head.next;// tmp - next head in direct part
                head.next = curr;// preappending "direct" head to the reversed list
                curr = head;// move head of reversed part to a new node
                head = temp;// move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
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
