package Leetcode;

/*
1. 아이디어 :
- DFS를 사용해서 height balanced BST를 만드는 문제입니다.
- 링크드 리스트의 값들을 모두 구합니다.
- 중간값을 루트로 설정하고, 왼쪽과 오른쪽 서브트리를 재귀적으로 만듭니다.

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
- / DFS
 */

public class Q109 {
/*
class Solution {
    List<Integer> nums = new ArrayList<>();

    public TreeNode makeTree(int startIdx, int endIdx) {
        if (startIdx > endIdx) return null;
        int mid = (endIdx + startIdx) / 2;
        TreeNode root = new TreeNode(nums.get(mid));

        root.left = makeTree(startIdx, mid-1);
        root.right = makeTree(mid+1, endIdx);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }

        return makeTree(0, nums.size()-1);
    }
}
 */
}
