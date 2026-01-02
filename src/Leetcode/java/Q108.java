package Leetcode.java;

/*
1. 아이디어 :
재귀적으로 root를 만듭니다.

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
DFS
 */

public class Q108 {
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
//    class Solution {
//        public TreeNode sortedArrayToBST(int[] nums) {
//            int n = nums.length;
//            return dfs(nums, 0, n);
//        }
//
//        public TreeNode dfs(int[] nums, int left, int right) {
//            if (left == right) return null;
//
//            int midI = (right + left) / 2;
//            TreeNode root = new TreeNode( nums[midI] );
//            root.left = dfs(nums, left, midI);
//            root.right = dfs(nums, midI + 1, right);
//            return root;
//        }
//    }
}
