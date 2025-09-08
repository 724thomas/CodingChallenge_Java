package Leetcode.java;

import java.util.HashSet;
import java.util.Set;

public class Q250 {
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
        int count = 0;

        public Set<Integer> dfs(TreeNode node) {
            if (node == null) return new HashSet<>();

            Set<Integer> lSet = dfs(node.left);
            if (lSet.size()==1) count++;
            Set<Integer> rSet = dfs(node.right);
            if (rSet.size()==1) count++;

            lSet.addAll(rSet);
            lSet.add(node.val);
            return lSet;
        }
        public int countUnivalSubtrees(TreeNode root) {
            if (dfs(root).size()==1) {
                count++;
            }
            return count;
        }
    }
}
