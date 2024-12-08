package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q1214 {
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
     */
    /*
    class Solution {
        Set<Integer> nums = new HashSet<>();
        public void fillNums (TreeNode node) {
            if (node==null) return;
            nums.add(node.val);
            fillNums(node.left);
            fillNums(node.right);
        }

        public boolean checkNums (TreeNode node, int target) {
            if (node==null) return false;

            boolean exist = checkNums(node.left, target) || checkNums(node.right, target);
            return nums.contains(target - node.val) || exist;
        }

        public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
            fillNums(root1);
            return checkNums(root2, target);
        }
    }*/
}
