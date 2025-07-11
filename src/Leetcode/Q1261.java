package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashSet;
import java.util.Set;

public class Q1261 {
/*
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

class FindElements {
    Set<Integer> exists;

    public void dfs(TreeNode node, int val) {
        if (node == null) return;

        exists.add(val);
        dfs(node.left, 2 * val + 1);
        dfs(node.right, 2 * val + 2);
    }

    public FindElements(TreeNode root) {
        exists = new HashSet<>();
        dfs(root, 0);
    }

    public boolean find(int target) {
        return exists.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
}
