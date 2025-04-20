package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;

public class Q2326 {
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
    public int[][] spiralMatrix(int n, int m, ListNode head) {
        int[][] ans = new int[n][m];
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int dir = 0;
        for (var a : ans) Arrays.fill(a, -1);

        ListNode curr = new ListNode(-1);
        curr.next = head;
        int x = 0, y = -1;
        while (curr.next != null) {
            if (x+dx[dir]<0 || y+dy[dir]<0 || x+dx[dir]>=n || y+dy[dir]>=m ||
                    ans[x+dx[dir]][y+dy[dir]] != -1) {
                dir = (dir+1)%4;
            } else {
                curr = curr.next;
                x+=dx[dir];
                y+=dy[dir];
                ans[x][y] = curr.val;
            }
        }
        return ans;
    }
}
 */
}
