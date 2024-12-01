package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q366 {
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
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> leaves;

        public boolean dfs(TreeNode node) {
            if (node == null) return false;

            if (node.left == null && node.right == null) {
                leaves.add(node.val);
                return true;
            }

            if (dfs(node.left)) node.left = null;
            if (dfs(node.right)) node.right = null;
            return false;
        }

        public List<List<Integer>> findLeaves(TreeNode root) {
            while (root.left != null || root.right!= null) {
                leaves = new ArrayList<>();
                dfs(root);
                ans.add(new ArrayList<>(leaves));
            }
            ans.add(new ArrayList<>(List.of(root.val)));
            return ans;


        }
    }
}
