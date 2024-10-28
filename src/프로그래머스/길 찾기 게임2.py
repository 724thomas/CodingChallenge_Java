# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    y 내림차순, x 오름차순으로 정렬
    재귀를 통해 트리를 만들어주고 전위, 후위 순회
2. 시간복잡도 :
    O( n log n )
3. 자료구조 :
    배열

import java.util.*;

class Solution {
    class Node {
        int index;
        int x;
        int y;
        Node left;
        Node right;

        public Node(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }

        public void insert(Node child) {
            if (child.x < this.x) {
                if (this.left == null) {
                    this.left = child;
                } else {
                    this.left.insert(child);
                }
            } else if (child.x > this.x) {
                if (this.right == null) {
                    this.right = child;
                } else {
                    this.right.insert(child);
                }
            }
        }
    }

    private void preOrder(Node node) {
        if (node == null) return;
        preOrderList.add(node.index);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        postOrderList.add(node.index);
    }

    private List<Integer> preOrderList;
    private List<Integer> postOrderList;

    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        //y 내림차순, x 오름차순
        Arrays.sort(nodes, (a, b) -> {
            if (a.y != b.y) {
                return b.y - a.y;
            } else {
                return a.x - b.x;
            }
        });

        Node root = nodes[0];
        for (int i = 1; i < nodes.length; i++) {
            root.insert(nodes[i]);
        }

        preOrderList = new ArrayList<>();
        postOrderList = new ArrayList<>();

        preOrder(root);
        postOrder(root);

        int[][] answer = new int[2][n];
        for (int i = 0; i < n; i++) {
            answer[0][i] = preOrderList.get(i);
            answer[1][i] = postOrderList.get(i);
        }
        return answer;
    }
}


'''


import sys
sys.setrecursionlimit(10000)
def solution(nodeinfo):
    class Node:
        def __init__(self, idx, x, y):
            self.idx = idx
            self.x = x
            self.y = y
            self.left = None
            self.right = None

        def insert(self, child):
            if child.x < self.x:
                if self.left is None:
                    self.left = child
                else:
                    self.left.insert(child)
            elif child.x > self.x:
                if self.right is None:
                    self.right = child
                else:
                    self.right.insert(child)

    preorderList = []
    postorderList = []

    def preorder(node):
        if not node: return
        preorderList.append(node.idx)
        preorder(node.left)
        preorder(node.right)

    def postorder(node):
        if not node: return
        postorder(node.left)
        postorder(node.right)
        postorderList.append(node.idx)

    nodes = [Node(i+1, x, y) for i, (x, y) in enumerate(nodeinfo)]
    nodes.sort(key= lambda node: (-node.y, node.x))

    root = nodes[0];
    for node in nodes[1:]:
        root.insert(node)

    preorder(root)
    postorder(root)

    return [preorderList, postorderList]