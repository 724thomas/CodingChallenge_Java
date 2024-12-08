package Leetcode;

public class Q333 {
    /*
    class Solution {
        int ans = 0;

        public int[] check(TreeNode node) {
            if (node == null) return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};

            int[] left = check(node.left);
            int[] right = check(node.right);

            if (left[0] == -1 || right[0] == -1 || node.val <= left[2] || node.val >= right[1]) {
                return new int[]{-1, 0, 0};
            }

            int size = 1 + left[0] + right[0];
            ans = Math.max(ans, size);

            int minVal = Math.min(node.val, left[1]);
            int maxVal = Math.max(node.val, right[2]);
            return new int[]{size, minVal, maxVal};
        }

        public int largestBSTSubtree(TreeNode root) {
            check(root);
            return ans;
        }
    }
*/
}
