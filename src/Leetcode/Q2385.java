package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q2385 {
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
    Map<Integer, List<TreeNode>> neighbors = new HashMap<>();

    public void dfsNeighbors(TreeNode node, TreeNode parent) {
        if (node == null) return;

        neighbors.put(node.val, new ArrayList<>());
        if (parent != null) {
            neighbors.get(node.val).add(parent);
        }

        if (node.left != null) {
            neighbors.get(node.val).add(node.left);
            dfsNeighbors(node.left, node);
        }
        if (node.right != null) {
            neighbors.get(node.val).add(node.right);
            dfsNeighbors(node.right, node);
        }
    }

    public int amountOfTime(TreeNode root, int start) {
        dfsNeighbors(root, null);

        Deque<int[]> deque = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        deque.add(new int[]{start, 0});
        visited.add(start);

        int ans = 0;
        while (!deque.isEmpty()) {
            int[] c = deque.pollFirst();
            int currNode = c[0], time = c[1];
            ans = Math.max(ans, time);

            for (TreeNode neighbor : neighbors.getOrDefault(currNode, new ArrayList<>())) {
                if (visited.contains(neighbor.val)) continue;
                deque.add(new int[]{neighbor.val, time+1});
                visited.add(neighbor.val);
            }
        }

        return ans;
    }
}
 */
}
