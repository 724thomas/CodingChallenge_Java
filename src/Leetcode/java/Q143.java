package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q143 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }

    class Solution {
        public void reorderList(ListNode head) {
            List<ListNode> arr = new ArrayList<>();
            ListNode curr = head;
            arr.add(curr);
            while (curr.next != null) {
                curr = curr.next;
                arr.add(curr);
            }

            int left = 0, right = arr.size()-1;

            ListNode dummy = new ListNode(-1);
            curr = dummy;
            while (left < right) {
                curr.next = arr.get(left++);
                curr = curr.next;
                curr.next = arr.get(right--);
                curr = curr.next;
            }
            if (arr.size()%2 == 1) {
                curr.next = arr.get(left);
                curr = curr.next;
            }
            curr.next = null;
        }
    }
     */
}
