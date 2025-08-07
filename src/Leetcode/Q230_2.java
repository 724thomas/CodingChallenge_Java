package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q230_2 {
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
    int count=0;
    int ans=0;

    public void dfs(TreeNode node, int k){
        if (node == null || ans != 0) return;


        dfs(node.left, k);
        count++;
        if (count == k){
            ans = node.val;
            return;
        }
        dfs(node.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }
}
 */
}
