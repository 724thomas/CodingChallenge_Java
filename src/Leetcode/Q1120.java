package Leetcode;

public class Q1120 {
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
        double ans = 0;
        public double[] dfs(TreeNode node) {
            if (node == null) return new double[]{0,0,0}; //count, total, max

            double[] left = dfs(node.left);
            double[] right = dfs(node.right);

            double count = left[0] + right[0] + 1;
            double total = left[1] + right[1] + node.val;

            ans = Math.max(ans, Math.max(left[2], right[2]));
            ans = Math.max(ans, total / count);
            return new double[]{count, total, total/count};
        }
        public double maximumAverageSubtree(TreeNode root) {
            dfs(root);
            return ans;
        }
    }
}
