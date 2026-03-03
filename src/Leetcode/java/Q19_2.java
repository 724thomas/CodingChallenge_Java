package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayDeque;

public class Q19_2 {
//    /**
//     * Definition for singly-linked list.
//     * public class ListNode {
//     *     int val;
//     *     ListNode next;
//     *     ListNode() {}
//     *     ListNode(int val) { this.val = val; }
//     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//     * }
//     */
//    class Solution {
//        public ListNode removeNthFromEnd(ListNode head, int n) {
//            ListNode dummy = new ListNode(-1);
//            dummy.next = head;
//            ListNode curr = dummy;
//            Deque<ListNode> deque = new ArrayDeque<>();
//
//            while (curr != null) {
//                if (deque.size() > n) deque.pollFirst();
//                deque.add(curr);
//                curr = curr.next;
//            }
//
//            ListNode prev = deque.pollFirst();
//            deque.pollFirst();
//            prev.next = deque.pollFirst();
//
//            return dummy.next;
//        }
//    }
}
