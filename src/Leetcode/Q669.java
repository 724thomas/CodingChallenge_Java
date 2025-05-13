package Leetcode;

/*
1. 아이디어 :
재귀적으로 탐색
- root가 null이면 null을 리턴
- root.val이 low보다 작으면 오른쪽 서브트리 탐색
- root.val이 high보다 크면 왼쪽 서브트리 탐색
- root.val이 low와 high 사이에 있으면
  - 왼쪽 서브트리 탐색
  - 오른쪽 서브트리 탐색
  - root를 리턴

2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q669 {
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) return trimBST(root.right, low, high);
        if (root.val > high) return trimBST(root.left, low, high);
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
 */
}
