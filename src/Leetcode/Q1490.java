package Leetcode;

public class Q1490 {
// class Node {
//     public int val;
//     public List<Node> children;

//     public Node() {
//         children = new ArrayList<Node>();
//     }

//     public Node(int _val) {
//         val = _val;
//         children = new ArrayList<Node>();
//     }

//     public Node(int _val,ArrayList<Node> _children) {
//         val = _val;
//         children = _children;
//     }
// };
/*
    class Solution {
        public void clone(Node root, Node root2) {
            for (Node child : root.children) {
                Node newChild = new Node(child.val);
                root2.children.add(newChild);
                clone(child, newChild);
            }
        }

        public Node cloneTree(Node root) {
            if (root==null) return null;
            Node head = new Node(root.val);
            clone(root, head);
            return head;
        }
    }
    */
}
