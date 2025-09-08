package Leetcode.java;

public class Q1265 {
    /**
     * // This is the ImmutableListNode's API interface.
     * // You should not implement it, or speculate about its implementation.
     * interface ImmutableListNode {
     *     public void printValue(); // print the value of this node.
     *     public ImmutableListNode getNext(); // return the next node.
     * };
     */
    class ImmutableListNode {
        int val;
        ImmutableListNode next;

        public void printValue() {

        }
        public ImmutableListNode getNext() {
            return this.next;
        }
    }

    class Solution {
        public void dfs(ImmutableListNode node) {
            if (node ==null) return;
            dfs(node.getNext());
            node.printValue();
        }
        public void printLinkedListInReverse(ImmutableListNode head) {
            dfs(head);
        }
    }
}
