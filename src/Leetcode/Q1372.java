package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;

public class Q1372 {
/*

class Solution {
    Map<TreeNode, int[]> memo = new HashMap<>();

    public int[] dfs(TreeNode node) { //dir: 0 left, 1 right
        if (memo.containsKey(node)) return memo.get(node);
        int[] lengths = new int[2];
        lengths[0] = (node.left != null)? 1 + dfs(node.left)[1] : 1;
        lengths[1] = (node.right != null) ? 1 + dfs(node.right)[0] : 1;
        memo.put(node, lengths);
        return lengths;
    }
    public int longestZigZag(TreeNode root) {
        dfs(root);
        int ans = Math.max(memo.get(root)[0], memo.get(root)[1]-1);
        for (var a : memo.entrySet()) {
            ans = Math.max(ans, Math.max(a.getValue()[0], a.getValue()[1]));
        }
        return ans-1;

    }
}
 */
}
