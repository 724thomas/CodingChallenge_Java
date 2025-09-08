package Leetcode.java;

public class Q270 {
/*
class Solution {
    double difference = Double.MAX_VALUE;
    int ans = -1;

    public void traverse(TreeNode node, double target) {
        if (node==null) return;

        int curr = node.val;
        double diff = Math.abs(target - curr);
        if (diff < difference) {
            ans = curr;
            difference = diff;
        }
        if (diff == difference) {
            ans = Math.min(ans, curr);
        }

        traverse(node.left, target);
        traverse(node.right, target);
    }
    public int closestValue(TreeNode root, double target) {
        traverse(root, target);
        return ans;
    }
}
 */
}
