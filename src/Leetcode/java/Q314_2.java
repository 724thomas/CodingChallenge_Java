package Leetcode.java;

import java.util.*;

public class Q314_2 {
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


    class NodeInfo {
        private TreeNode key;
        private int value;

        public NodeInfo(TreeNode key, int value) {
            this.key = key;
            this.value = value;
        }
        public TreeNode getKey() {
            return key;
        }
        public int getValue() {
            return value;
        }
    }

    class Solution {
        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) return ans;

            Map<Integer, List<Integer>> columnMap = new TreeMap<>();

            Queue<NodeInfo> queue = new LinkedList<>();
            queue.offer(new NodeInfo(root, 0));

            while (!queue.isEmpty()) {
                NodeInfo item = queue.poll();
                TreeNode node = item.getKey();
                int col = item.getValue();

                columnMap.putIfAbsent(col, new ArrayList<>());
                columnMap.get(col).add(node.val);

                if (node.left != null) {
                    queue.offer(new NodeInfo(node.left, col-1));
                }
                if (node.right != null) {
                    queue.offer(new NodeInfo(node.right, col+1));
                }
            }
            for (List<Integer> column : columnMap.values()) {
                ans.add(column);
            }
            return ans;
        }
    }
}
