package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.HashSet;

public class Q235 {
/*
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }


    class Solution {
        Map<TreeNode, TreeNode> parMap = new HashMap<>();
        public void dfs(TreeNode node, TreeNode par) {
            if (node == null) return;
            parMap.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root, new TreeNode(-1));
            Set<TreeNode> pPars = new HashSet<>();

            TreeNode curr = p;
            while (parMap.containsKey(curr)) {
                pPars.add(curr);
                curr = parMap.get(curr);
            }

            curr = q;
            while (parMap.containsKey(curr)) {
                if (pPars.contains(curr)) return curr;
                curr = parMap.get(curr);
            }
            return null;
        }
    }
 */
}
