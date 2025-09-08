package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3479 {
    class Solution {
        int[] tree;
        public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
            int n = fruits.length; // <=100,000
            tree = new int[4*n];
            build(baskets, 0, 0, n-1);
            int ans = 0;
            // System.out.println(Arrays.toString(tree));

            for (int fruit : fruits) {
                int idx = query(0, 0, n-1, 0, n-1, fruit);
                if (idx == -1) {
                    ans ++;
                } else {
                    use(idx, 0, 0, n-1);
                }
                // System.out.println(Arrays.toString(tree));
            }
            return ans;

        }

        private void build(int[] baskets, int node, int left, int right) {
            if (left == right) {
                tree[node] = baskets[left];
                return;
            }

            int mid = left + (right-left)/2;
            build(baskets, 2 * node+1, left, mid);
            build(baskets, 2 * node+2, mid+1, right);
            tree[node] = Math.max(tree[2 * node+1], tree[2 * node+2]);
        }

        private void use(int idx, int node, int left, int right) {
            if (left == right) {
                tree[node] = -1;
                return;
            }

            int mid = left + (right-left)/2;
            if (idx <= mid) {
                use(idx, 2 * node+1, left, mid);
            } else {
                use(idx, 2 * node+2, mid+1, right);
            }
            tree[node] = Math.max(tree[2 * node+1], tree[2 * node+2]);
        }

        private int query(int node, int left, int right, int qleft, int qright, int fruit) {
            // 범위에 포함 안되거나, 현재 바구니가 작은 경우
            if (qright < left || right < qleft || tree[node] < fruit) return -1;
            if (left == right) return left;

            int mid = left + (right-left)/2;
            int leftRes = query(2 * node+1, left, mid, qleft, qright, fruit);
            if (leftRes != -1) return leftRes; //먼저 나오는 idx 반환
            int rightRes = query(2 * node+2, mid+1, right, qleft, qright, fruit);
            return rightRes;

        }
    }
}
