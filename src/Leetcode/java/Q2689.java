package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2689 {
//    /**
//     * Definition for a rope tree node.
//     * class RopeTreeNode {
//     *     int len;
//     *     String val;
//     *     RopeTreeNode left;
//     *     RopeTreeNode right;
//     *     RopeTreeNode() {}
//     *     RopeTreeNode(String val) {
//     *         this.len = 0;
//     *         this.val = val;
//     *     }
//     *     RopeTreeNode(int len) {
//     *         this.len = len;
//     *         this.val = "";
//     *     }
//     *     RopeTreeNode(int len, RopeTreeNode left, RopeTreeNode right) {
//     *         this.len = len;
//     *         this.val = "";
//     *         this.left = left;
//     *         this.right = right;
//     *     }
//     * }
//     */
//    class Solution {
//        public char getKthCharacter(RopeTreeNode root, int k) {
//            return dfs(root, k - 1);
//        }
//
//        private char dfs(RopeTreeNode node, int k) {
//            if (node.left == null && node.right == null) {
//                return node.val.charAt(k);
//            }
//
//            int leftLen = 0;
//            if (node.left != null) {
//                if (node.left.len > 0) {
//                    leftLen = node.left.len;
//                } else {
//                    leftLen = node.left.val.length();
//                }
//            }
//
//            return (k<leftLen)? dfs(node.left,k) : dfs(node.right, k-leftLen);
//        }
//    }

}
