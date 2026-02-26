package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.HashSet;

public class Q235_2 {
//    /**
//     * Definition for a binary tree node.
//     * public class TreeNode {
//     *     int val;
//     *     TreeNode left;
//     *     TreeNode right;
//     *     TreeNode(int x) { val = x; }
//     * }
//     */
//
//    class Solution {
//        Map<TreeNode, TreeNode> parMap = new HashMap<>();
//        Set<TreeNode> visited = new HashSet<>();
//
//        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//            createMap(root, null);
//
//            TreeNode curr = p;
//            while (p != null) {
//                visited.add(p);
//                p = parMap.get(p);
//            }
//
//            curr = q;
//            while (q != null) {
//                if (visited.contains(q)) {
//                    return q;
//                }
//                q = parMap.get(q);
//            }
//
//            return null;
//        }
//
//
//
//        public void createMap(TreeNode curr, TreeNode par) {
//            if (curr == null) return;
//            parMap.put(curr, par);
//            createMap(curr.left, curr);
//            createMap(curr.right, curr);
//        }
//    }
}
