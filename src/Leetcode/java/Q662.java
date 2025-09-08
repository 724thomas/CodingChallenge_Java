package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q662 {
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
    Map<Integer, int[]> maxWidth = new HashMap<>();
    int maxDepths = 0;

    public void dfs(TreeNode node, int depth, int pos) {
        if (node == null) return;

        if (!maxWidth.containsKey(depth)) {
            int[] temp = new int[2];
            temp[0] = Integer.MAX_VALUE;
            temp[1] = Integer.MIN_VALUE;
            maxWidth.put(depth, temp);
        }

        maxWidth.get(depth)[0] = Math.min(maxWidth.get(depth)[0], pos);
        maxWidth.get(depth)[1] = Math.max(maxWidth.get(depth)[1], pos);

        dfs(node.left, depth+1, pos*2);
        dfs(node.right, depth+1, pos*2+1);
    }

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 1, 0);
        int ans = 0;
        for (var minMax: maxWidth.values()) {
            ans = Math.max(ans, Math.abs(minMax[1] - minMax[0])+1);
        }

        return ans;
    }
}
 */
}
