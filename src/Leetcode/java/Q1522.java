package Leetcode.java;

public class Q1522 {
/*

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
/*
    class Solution {
        int ans = 0;

        public int getDiameter(Node node) {
            if (node == null) return 0;
            int largest = 0;
            int larger = 0;
            for (Node child : node.children) {
                int childDiameter = getDiameter(child);
                if (childDiameter > largest) {
                    larger = largest;
                    largest = childDiameter;
                } else if( childDiameter > larger) {
                    larger = childDiameter;
                }
            }
            ans = Math.max(ans, larger + largest);
            return largest+1;
        }
        public int diameter(Node root) {
            getDiameter(root);
            return ans;
        }
    }
 */
}
