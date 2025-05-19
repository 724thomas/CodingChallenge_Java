package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q117 {
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


    class Solution {
        Map<Integer, Node> depthsMap = new HashMap<>();
        public void postOrder(Node node, int depths) {
            if (node == null) return;

            postOrder(node.right, depths+1);
            postOrder(node.left, depths+1);

            node.next = depthsMap.getOrDefault(depths, null);
            depthsMap.put(depths, node);
        }

        public Node connect(Node root) {
            postOrder(root, 0);
            return root;
        }
    }
 */
}
