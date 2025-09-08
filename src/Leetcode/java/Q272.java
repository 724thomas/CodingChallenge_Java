package Leetcode.java;

public class Q272 {
/*
class Solution {
    PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> {
        if (a[1] == b[1]) return Double.compare(a[0], b[0]);
        return Double.compare(a[1], b[1]);
    }); //value, diff

    public void traverse(TreeNode node, double target) {
        if (node == null) return;
        pq.offer(new double[]{node.val, Math.abs(target - node.val)});

        traverse(node.left, target);
        traverse(node.right, target);
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> ans = new ArrayList<>();
        traverse(root, target);
        for (int i=0; i<k; i++) {
            ans.add((int)pq.poll()[0]);
        }
        return ans;
    }
}
 */
}
