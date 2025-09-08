package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1457 {
/*
class Solution {
    int ans = 0;
    int[] counter = new int[100001];

    public void dfs(TreeNode node, int odds) {
        if (node == null) return;

        int val = node.val;
        int count = ++counter[val];
        odds += (count % 2 == 1) ? 1 : -1;

        if (node.left == null && node.right == null && odds <= 1) ans++;

        dfs(node.left, odds);
        dfs(node.right, odds);

        counter[val]--;
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
}

 */
}
