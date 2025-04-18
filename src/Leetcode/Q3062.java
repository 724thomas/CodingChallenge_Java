package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3062 {
    /*
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
    class Solution {
        public String gameResult(ListNode head) {
            int[] scores = new int[2]; // odd even
            ListNode curr = head;
            while (curr!=null) {
                int even = curr.val;
                curr = curr.next;
                int odd = curr.val;
                curr = curr.next;
                if (odd > even) scores[0]++;
                if (even > odd) scores[1]++;
            }

            if (scores[0] > scores[1]) return "Odd";
            if (scores[0] < scores[1]) return "Even";
            return "Tie";
        }
    }
     */
}
