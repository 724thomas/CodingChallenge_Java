package Leetcode.java;

import java.util.*;





public class Q314 {
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

    class Item<K, V> {
        private K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }

    class Solution {
        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) return ans;

            Map<Integer, List<Integer>> columnMap = new TreeMap<>();

            Queue<Item<TreeNode, Integer>> queue = new LinkedList<>();
            queue.offer(new Item<>(root, 0));

            while (!queue.isEmpty()) {
                Item<TreeNode, Integer> item = queue.poll();
                TreeNode node = item.getKey();
                int col = item.getValue();

                columnMap.putIfAbsent(col, new ArrayList<>());
                columnMap.get(col).add(node.val);

                if (node.left != null) {
                    queue.offer(new Item<>(node.left, col-1));
                }
                if (node.right != null) {
                    queue.offer(new Item<>(node.right, col+1));
                }
            }
            for (List<Integer> column : columnMap.values()) {
                ans.add(column);
            }
            return ans;
        }
    }
}
