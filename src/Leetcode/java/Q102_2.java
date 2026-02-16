package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q102_2 {
//    /**
//     * Definition for a binary tree node.
//     * public class TreeNode {
//     *     int val;
//     *     TreeNode left;
//     *     TreeNode right;
//     *     TreeNode() {}
//     *     TreeNode(int val) { this.val = val; }
//     *     TreeNode(int val, TreeNode left, TreeNode right) {
//     *         this.val = val;
//     *         this.left = left;
//     *         this.right = right;
//     *     }
//     * }
//     */
//    class Solution {
//        Map<Integer, List<Integer>> map = new HashMap<>();
//
//        public List<List<Integer>> levelOrder(TreeNode root) {
//            dfs(root, 0);
//            List<List<Integer>> ans = new ArrayList<>();
//            for (var entry: map.entrySet()) {
//                ans.add(entry.getValue());
//            }
//            return ans;
//        }
//
//        private void dfs(TreeNode node, int level) {
//            if (node == null) return;
//
//            List<Integer> values = map.getOrDefault(level, new ArrayList<>());
//            values.add(node.val);
//            map.put(level, values);
//
//            dfs(node.left, level+1);
//            dfs(node.right, level+1);
//        }
//    }
}
