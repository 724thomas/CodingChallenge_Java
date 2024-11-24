package Leetcode;

public class Q298 {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    class Solution {
        int ans = 1;
        public void dfs(int prev, int length, TreeNode node) {
            if (node == null) {
                ans = Math.max(ans, length);
                return;
            }

            if (node.val == prev + 1) {
                dfs(node.val, length+1, node.left);
                dfs(node.val, length+1, node.right);
            } else {
                ans = Math.max(ans, length);
                dfs(node.val, 1, node.left);
                dfs(node.val, 1, node.right);
            }
        }

        public int longestConsecutive(TreeNode root) {
            dfs(root.val-1, 0, root);
            return ans;
        }
    }
}
