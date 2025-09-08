package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2476 {
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
    TreeSet<Integer> values = new TreeSet<>();

    private void dfs(TreeNode node) {
        if (node==null) return;
        dfs(node.left);
        values.add(node.val);
        dfs(node.right);
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        dfs(root);
        List<List<Integer>> ans = new ArrayList<>();
        for (int q : queries) {
            List<Integer> qAns = new ArrayList<>();
            Integer left = values.floor(q);
            qAns.add(left == null? -1:left);

            Integer right = values.ceiling(q);
            qAns.add(right == null? -1:right);
            ans.add(qAns);
        }
        return ans;
    }
}
 */
}
