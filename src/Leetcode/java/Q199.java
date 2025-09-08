package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q199 {
/*
/**
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
    Map<Integer, Integer> levels = new HashMap<>();
    int maxLevel = 0;
    public void dfs(TreeNode node, int level) {
        if (node == null) return;
        maxLevel = Math.max(maxLevel, level);
        levels.putIfAbsent(level, node.val);

        dfs(node.right, level+1);
        dfs(node.left, level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        dfs(root, 0);
        for (int i=0; i<=maxLevel; i++) ans.add(levels.get(i));
        return ans;
    }
}
 */
}
