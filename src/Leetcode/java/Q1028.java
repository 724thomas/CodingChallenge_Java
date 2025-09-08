package Leetcode.java;

/*
1. 아이디어 :
- Pair 클래스를 만들어서, 노드와 깊이를 저장.
- 스택을 사용해서 Pair을 저장.
- 문자열을 순회하면서, '-'의 갯수만큼 level과 그 뒤 숫자를 추출.
- TreeNode 객체와 Pair 객체를 생성.
- 스택의 마지막 Node의 level이 현재 level보다 하나 작을떄까지(부모일때까지) poll.
- 부모 Node를 찾으면, 해당 Node의 왼쪽 자식이 비어 있으면, 왼쪽 자식으로, 오른쪽 자식이 비어 있으면 오른쪽 자식으로 현재 노드를 추가.
- 스택에 현재 Pair를 추가.
- 스택의 첫번째 Pair의 노드를 반환.

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
Deque / 스택
 */

public class Q1028 {
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
class Pair {
    TreeNode node;
    int level;

    public Pair(int level, TreeNode node) {
        this.node = node;
        this.level = level;
    }
}

    class Solution {
        Map<Integer, List<Integer>> level = new HashMap<>();

        public TreeNode recoverFromPreorder(String traversal) {
            Deque<Pair> deque = new ArrayDeque<>();

            int n = traversal.length();
            int idx = 0;
            while (idx < n) {
                int level = 0;
                StringBuilder sb = new StringBuilder();
                while (idx < n && traversal.charAt(idx) == '-') {
                    level++;
                    idx++;
                }
                while (idx < n && traversal.charAt(idx) != '-') {
                    sb.append(traversal.charAt(idx));
                    idx++;
                }

                TreeNode currNode = new TreeNode(Integer.parseInt(sb.toString()));
                Pair currPair = new Pair(level, currNode);

                while (!deque.isEmpty() && deque.peekLast().level != level-1) {
                    deque.pollLast();
                }
                if (!deque.isEmpty() && deque.peekLast().node.left == null) {
                    deque.peekLast().node.left = currNode;
                } else if (!deque.isEmpty() && deque.peekLast().node.right == null) {
                    deque.peekLast().node.right = currNode;
                }
                deque.add(currPair);
            }
            return deque.pollFirst().node;
        }
    }
 */
}
