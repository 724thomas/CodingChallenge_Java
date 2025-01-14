package Leetcode;

import java.util.*;

public class Q863 {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode(int x) {
             val = x;
         }
     }

    class Solution {
        Map<TreeNode, TreeNode> parMap;

        public void dfs(TreeNode node, TreeNode par) {
            if (node == null) return;

            parMap.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }

        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            List<Integer> ans = new ArrayList<>();
            parMap = new HashMap<>();
            dfs(root, null);

            Set<Integer> visited = new HashSet<>();
            visited.add(target.val);
            Queue<TreeNode> queue1 = new ArrayDeque<>();
            queue1.add(target);

            for (int i=0; i<k; i++) {
                Queue<TreeNode> queue2 = new ArrayDeque<>();

                while(!queue1.isEmpty()) {
                    TreeNode c = queue1.poll();
                    if (c.left!=null && !visited.contains(c.left.val)) {
                        queue2.add(c.left);
                        visited.add(c.left.val);
                    }

                    if (c.right!=null && !visited.contains(c.right.val)) {
                        queue2.add(c.right);
                        visited.add(c.right.val);
                    }

                    if (parMap.containsKey(c) && parMap.get(c) != null && !visited.contains(parMap.get(c).val)) {
                        queue2.add(parMap.get(c));
                        visited.add(parMap.get(c).val);
                    }
                }
                queue1 = queue2;
            }

            while (!queue1.isEmpty()) ans.add(queue1.poll().val);
            return ans;
        }
    }
}
