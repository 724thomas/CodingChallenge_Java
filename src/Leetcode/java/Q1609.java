package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1609 {
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
    boolean ans = true;
    Map<Integer, Integer> map = new HashMap<>();

    public void preOrder(TreeNode node, int depths) {
        if (node==null) return;

        if (!map.containsKey(depths)) {
            map.put(depths, depths%2 == 0? Integer.MIN_VALUE : Integer.MAX_VALUE);
        }
        int prev = map.get(depths);
        if (depths%2 == node.val%2 || (depths % 2 == 0 && prev >= node.val)
                || (depths % 2 == 1 && prev <= node.val)) ans = false;
        map.put(depths, node.val);

        preOrder(node.left, depths+1);
        preOrder(node.right, depths+1);
    }

    public boolean isEvenOddTree(TreeNode root) {
        preOrder(root, 0);
        return ans;
    }
}
 */
}
