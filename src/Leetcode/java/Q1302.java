package Leetcode.java;

/*
1. 아이디어 :
dfs / bfs를 통해 완전 탐색을 진행합니다.
노드를 방문할때, 해당 level의 값을 해시맵에 저장합니다.
가장 깊은 level을 mlevel로 저장하고, mlevel의 값을 리턴합니다.

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
맵 / dfs
 */

public class Q1302 {
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
    int mlevel = 0;
    Map<Integer, Integer> levelTotal = new HashMap<>();
    public void dfs(TreeNode node, int level) {
        if (node == null) return;
        mlevel = Math.max(mlevel, level);
        levelTotal.put(level, levelTotal.getOrDefault(level, 0)+node.val);

        dfs(node.left, level+1);
        dfs(node.right , level+1);
    }

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return levelTotal.get(mlevel);
    }
}


class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int mlevel = 0;
        int total = 0;
        Deque<Pair> deque = new ArrayDeque<>();
        deque.add(new Pair(root, 0));

        while (!deque.isEmpty()) {
            Pair curr = deque.poll();
            TreeNode node = curr.node;
            int level = curr.level;

            if (level > mlevel) {
                mlevel = level;
                total = node.val;
            } else {
                total += node.val;
            }

            if (node.left != null) {
                deque.add(new Pair(node.left, level+1));
            }
            if (node.right != null) {
                deque.add(new Pair(node.right, level+1));
            }
        }
        return total;
    }
}

 */
}
