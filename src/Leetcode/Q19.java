package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;

public class Q19 {
/*
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        List<ListNode> arr = new ArrayList<>();
        arr.add(curr);
        while (curr.next != null) {
            curr = curr.next;
            arr.add(curr);
        }
        if (arr.size() == 1) return null;
        if (n==1) {
            arr.get(arr.size()-2).next = null;
            return head;
        }
        if (n == arr.size()) return arr.get(1);

        int nodeIdx = arr.size()-n;
        arr.get(nodeIdx-1).next = arr.get(nodeIdx+1);
        return head;
    }
}
 */
}
