package Leetcode.java;

public class Q2415 {
/*
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        boolean odd = false;
        List<TreeNode> currList = new ArrayList<>();
        currList.add(root);

        while (!currList.isEmpty()) {
            List<TreeNode> nextList = new ArrayList<>();
            List<Integer> values = new ArrayList<>();
            for (TreeNode node : currList) {
                if (node.left!=null) {
                    nextList.add(node.left);
                    nextList.add(node.right);
                    values.add(node.left.val);
                    values.add(node.right.val);
                }
            }
            odd = !odd;
            if (odd) {
                for (int i=0; i<nextList.size(); i++) {
                    nextList.get(i).val = values.get(values.size()-1-i);
                }
            }
            currList = nextList;
        }
        return root;
    }
}
 */
}
