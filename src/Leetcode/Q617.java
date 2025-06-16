package Leetcode;

/*
1. 아이디어 :
재귀로 풀 수 있습니다.

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
- / -
 */

public class Q617 {
/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }

class Solution {
    public TreeNode mergeTrees(TreeNode node1, TreeNode node2) {
        if (node1 != null && node2 != null) {
            node1.val += node2.val;
            node1.left = mergeTrees(node1.left, node2.left);
            node1.right = mergeTrees(node1.right, node2.right);
            return node1;
        } else {
            return node1 != null? node1 : node2;
        }
    }
}
 */
}
