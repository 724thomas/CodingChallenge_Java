package Leetcode.java;

/*
1. 아이디어 :
재귀적으로 노드를 만들 수 있고, 캐싱을 통해 빠른 접근 가능

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q105 {

}
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
//class Solution {
//    Map<Integer, Integer> inorderIndexMap = new HashMap<>();
//    int preorderIndex = 0;
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        for (int i=0; i<inorder.length; i++) {
//            inorderIndexMap.put(inorder[i], i);
//        }
//
//        return build(preorder, 0, inorder.length-1);
//    }
//
//    public TreeNode build(int[] preorder, int left, int right) {
//        if (left > right) return null;
//
//        int rootVal = preorder[preorderIndex++];
//        TreeNode root = new TreeNode(rootVal);
//
//        int inorderIndex = inorderIndexMap.get(rootVal);
//
//        root.left = build(preorder, left, inorderIndex-1);
//        root.right = build(preorder, inorderIndex+1, right);
//        return root;
//    }
//}