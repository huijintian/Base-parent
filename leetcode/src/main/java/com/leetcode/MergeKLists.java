package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by mengtian on 2017/12/17
 * <p>
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKLists {
    public static void main(String[] args) {

        ListNode[] nodes = new ListNode[3];

        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(9);

        ListNode node3 = new ListNode(5);
        node3.next = new ListNode(10);

        nodes[0] = node1;
        nodes[1] = node2;
        nodes[2] = node3;

        System.out.println(new MergeKLists().mergeKLists2(nodes));
    }

    //这个方式运行时间超时了。
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode node = new ListNode(0);
        int index = 0;
        while (index < lists.length) {
            if (index == 0) {
                node = mergeTwoLists(lists[index++], lists[index++]);
            } else {
                node = mergeTwoLists(node, lists[index++]);
            }
        }
        return node;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    //https://leetcode.com/problems/merge-k-sorted-lists/discuss/
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparing(ListNode::getVal));

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null) {
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        @Override
        public String toString() {
            return "val:" + val + " --> next:" + next;
        }
    }
}
