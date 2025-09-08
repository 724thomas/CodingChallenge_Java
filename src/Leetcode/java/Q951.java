package Leetcode.java;

/*
1. 아이디어 :
dfs로 두 트리를 비교한다.
종료 조건
두 노드가 모두 null인 경우: true
두 노드 중 하나만 null인 경우: false
두 노드의 값이 다른 경우: false

노드1의 왼쪽과 노드2의 왼쪽이 true이고, 노드1의 오른쪽과 노드2의 오른쪽이 true인 경우: true
노드1의 오른쪽과 노드2의 왼쪽이 true이고, 노드1의 왼쪽과 노드2의 오른쪽이 true인 경우: true

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
- / dfs
 */

public class Q951 {
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
    boolean ans = true;
    public boolean dfs(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if ((node1 == null && node2 != null) || (node1 !=null && node2==null)) {
            return false;
        }
        if (node1.val != node2.val) return false;

        return (dfs(node1.left, node2.left) && dfs(node1.right, node2.right))
                || (dfs(node1.right, node2.left) && dfs(node1.left, node2.right));
    }
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);

    }
}
 */
}
