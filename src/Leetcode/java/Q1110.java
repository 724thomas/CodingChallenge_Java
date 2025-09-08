package Leetcode.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1110 {

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
        ArrayList<TreeNode> roots = new ArrayList<>();
        Set<Integer> deletes = new HashSet<>();

        public TreeNode dfs(TreeNode curr, boolean isRoot) {
            if (curr == null) return null;

            boolean toDelete = deletes.contains(curr.val);
            if (isRoot && !toDelete) roots.add(curr);

            curr.left = dfs(curr.left, toDelete);
            curr.right = dfs(curr.right, toDelete);

            return toDelete ? null : curr;
        }

        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            for (int d : to_delete) deletes.add(d);
            dfs(root, true);
            return roots;
        }
    }
}
