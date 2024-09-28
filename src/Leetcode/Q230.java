package Leetcode;

public class Q230 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        int count = 0;
        int ans = 0;

        public void dfs(TreeNode node, int k) {
            if (node == null || ans != 0) return;


            dfs(node.left, k);
            count++;
            if (count == k) {
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
}
