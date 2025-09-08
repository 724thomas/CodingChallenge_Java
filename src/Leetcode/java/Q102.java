package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q102 {
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
    Map<Integer, List<Integer>> levelMap = new HashMap<>();
    int maxLevel = 0;

    public void dfs(TreeNode node, int level) {
        if (node == null) return;
        maxLevel = Math.max(maxLevel, level);
        levelMap.putIfAbsent(level, new ArrayList<>());
        levelMap.get(level).add(node.val);
        dfs(node.left, level+1);
        dfs(node.right, level+1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        dfs(root, 0);
        for (int i=0; i<=maxLevel; i++) {
            ans.add(levelMap.get(i));
        }
        return ans;
    }
}
 */
}
