package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q545 {
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
        ArrayList<Integer> ans = new ArrayList<>();
        public void addLeft(TreeNode node) {
            if (node == null) return;

            if (node.left!=null) {
                ans.add(node.val);
                addLeft(node.left);
            } else if (node.right!=null) {
                ans.add(node.val);
                addLeft(node.right);
            }
        }

        public void addRight(TreeNode node) {
            if (node == null) return;

            if (node.right!=null) {
                addRight(node.right);
                ans.add(node.val);
            } else if (node.left!=null) {
                addRight(node.left);
                ans.add(node.val);
            }
        }

        public void addLeaves(TreeNode node) {
            if (node == null) return;

            if (node.left == null && node.right == null) {
                ans.add(node.val);
            }
            addLeaves(node.left);
            addLeaves(node.right);
        }

        public List<Integer> boundaryOfBinaryTree(TreeNode root) {
            ans.add(root.val);
            if (root.left != null) {
                addLeft(root.left);
            }
            if (root.left != null || root.right != null) {
                addLeaves(root);
            }
            if (root.right != null) {
                addRight(root.right);
            }
            return ans;
        }
    }
}
