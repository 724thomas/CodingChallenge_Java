package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q23 {
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
//        public ListNode mergeKLists(ListNode[] lists) {
//            ListNode ans = null;
//            for (ListNode list : lists) {
//                ans = merge(ans, list);
//            }
//            return ans;
//        }
//
//        public ListNode merge(ListNode l1, ListNode l2) {
//            ListNode dummy = new ListNode(-1);
//            ListNode pNode = dummy;
//            ListNode p1 = l1, p2 = l2;
//
//            while (p1 != null || p2 != null) {
//                if (p1 == null) {
//                    pNode.next = p2;
//                    pNode = pNode.next;
//                    p2 = p2.next;
//                } else if (p2 == null) {
//                    pNode.next = p1;
//                    pNode = pNode.next;
//                    p1 = p1.next;
//                } else {
//                    if (p1.val <= p2.val) {
//                        pNode.next = p1;
//                        pNode = pNode.next;
//                        p1 = p1.next;
//                    } else {
//                        pNode.next = p2;
//                        pNode = pNode.next;
//                        p2 = p2.next;
//                    }
//                }
//            }
//
//            return dummy.next;
//        }
//    }
}
