package Leetcode.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Q2583 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    class Solution {
        Map<Integer, Long> levelTotal = new HashMap<>();

        public void dfs(TreeNode node, int level) {
            if (node == null) return;
            levelTotal.put(level, levelTotal.getOrDefault(level, 0L)+node.val);
            dfs(node.left, level+1);
            dfs(node.right, level+1);
        }
        public long kthLargestLevelSum(TreeNode root, int k) {
            dfs(root, 1);
            int levels = levelTotal.size();
            ArrayList<Long> values = new ArrayList<>(levelTotal.values());
            values.sort((a,b) -> Long.compare(b,a));
            return k>values.size() ? -1 : values.get(k-1);
        }
    }
}
