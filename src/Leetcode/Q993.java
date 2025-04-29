package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q993 {
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
    List<Integer> depths = new ArrayList<>();
    List<Integer> parents = new ArrayList<>();
    int x, y;

    public void dfs(TreeNode node, int par, int depth) {
        if (node == null) return;
        if (node.val == x || node.val == y) {
            depths.add(depth);
            parents.add(par);
        }

        dfs(node.left, node.val, depth+1);
        dfs(node.right, node.val, depth+1);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        dfs(root, -1, 0);

        return (depths.get(0) == depths.get(1) && parents.get(0) != parents.get(1));
    }
}
 */
}
