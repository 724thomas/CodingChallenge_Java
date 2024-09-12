package Leetcode;

import java.util.HashSet;

public class Q3217 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode modifiedList(int[] nums, ListNode head) {
            var numset = new HashSet<Integer>();
            for (int num : nums) {
                numset.add(num);
            }

            var dummy = new ListNode(-1);
            dummy.next = head;

            var prev = dummy;
            var curr = head;

            while (curr != null) {
                if (numset.contains(curr.val)) {
                    prev.next = curr.next;
                } else {
                    prev = curr;
                }
                curr = curr.next;
            }

            return dummy.next;
        }
    }
}
