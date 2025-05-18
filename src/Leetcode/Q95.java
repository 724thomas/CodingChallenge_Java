package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q95 {
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
    public List<TreeNode> construct(int left, int right) {
        if (left == right) return List.of(new TreeNode(left));

        List<TreeNode> candids = new ArrayList<>();
        for (int val = left; val<right+1; val++) {
            List<TreeNode> lTrees = construct(left, val-1);
            List<TreeNode> rTrees = construct(val+1, right);
            if (lTrees.isEmpty()) {
                for (TreeNode rTree : rTrees) {
                    TreeNode root = new TreeNode(val, null, rTree);
                    candids.add(root);
                }
            } else if (rTrees.isEmpty()) {
                for (TreeNode lTree : lTrees) {
                    TreeNode root = new TreeNode(val, lTree, null);
                    candids.add(root);
                }
            } else {
                for (TreeNode lTree : lTrees) for (TreeNode rTree : rTrees) {
                    TreeNode root = new TreeNode(val, lTree, rTree);
                    candids.add(root);
                }
            }
        }
        return candids;
    }

    public List<TreeNode> generateTrees(int n) {
        return construct(1, n);
    }
}
 */
}
