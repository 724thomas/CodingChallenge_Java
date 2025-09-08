package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q429 {
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> ans = new ArrayList<>();

            Deque<Object[]> deque = new ArrayDeque<>();
            if (root == null) return ans;
            deque.add(new Object[]{root, 0});
            int level = 0;

            List<Integer> levelList = new ArrayList<>();
            while (!deque.isEmpty()) {
                Object[] obj = deque.pollFirst();
                Node curr = (Node)obj[0];
                int currLevel = (int)obj[1];
                if (currLevel != level) {
                    level = currLevel;
                    ans.add(new ArrayList<>(levelList));
                    levelList = new ArrayList<>();
                }
                levelList.add(curr.val);
                for (Node next:curr.children) {
                    deque.add(new Object[]{next, currLevel+1});
                }
            }
            ans.add(new ArrayList<>(levelList));

            return ans;
        }
    }
 */
}
