package Leetcode;

/*
1. 아이디어 :
bfs 방식ㄱ

2. 시간복잡도 :
O( nlogn )

3. 자료구조/알고리즘 :
- / bfs
 */

import java.util.*;

public class Q987 {

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
/*
    class Pair {
        TreeNode node;
        int x, y;

        public Pair(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    class Solution {
        Map<Integer, Map<Integer,List<Integer>>> map = new HashMap<>();
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            Deque<Pair> deque = new ArrayDeque<>();
            deque.add(new Pair(root, 0, 0));

            int minY = 0, maxY = 0;
            int minX = 0, maxX = 0;
            while (!deque.isEmpty()) {
                Pair currPair = deque.pollFirst();
                TreeNode currNode = currPair.node;
                int x = currPair.x, y = currPair.y;

                map.putIfAbsent(y, new HashMap<>());
                map.get(y).putIfAbsent(x, new ArrayList<>());
                map.get(y).get(x).add(currNode.val);

                if (currNode.left != null) {
                    deque.add(new Pair(currNode.left, x+1, y-1));
                }
                if (currNode.right != null) {
                    deque.add(new Pair(currNode.right, x+1, y+1));
                }
                minY = Math.min(minY, y-1);
                maxY = Math.max(maxY, y+1);
                maxX = Math.max(maxX, x+1);
            }

            List<List<Integer>> ans = new ArrayList<>();
            for (int i=minY; i<=maxY; i++) {
                if (map.containsKey(i)) {
                    List<Integer> inner = new ArrayList<>();
                    Map<Integer, List<Integer>> inMap = map.get(i);
                    for (int j=0; j<maxX; j++) {
                        if (inMap.containsKey(j)) {
                            Collections.sort(inMap.get(j));
                            inner.addAll(inMap.get(j));
                        }
                    }
                    ans.add(inner);
                }
            }

            return ans;


        }
    }

 */
}
