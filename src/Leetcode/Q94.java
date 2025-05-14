package Leetcode;

/*
1. 아이디어 :
inorder traversal = left -> root -> right

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
- / -
 */

public class Q94 {
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
 *
class Solution {
    List<Integer> ans = new ArrayList<>();
    public void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);
        ans.add(node.val);
        inorder(node.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return ans;
    }
}
 */
}
