package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;

public class Q307 {
    class NumArray {
        //segment tree

        int[] tree;
        int[] nums;
        int n;

        public void print() {
            System.out.println(Arrays.toString(tree));
        }

        public NumArray(int[] nums) {
            n = nums.length;
            this.nums = nums;
            tree = new int[4*n];
            buildTree(0, 0, n-1);
            // print();
        }

        private void buildTree(int node, int start, int end) {
            if (start == end) {
                tree[node] = nums[start];
                return;
            }

            int mid = (start+end) / 2;
            buildTree(2 * node +1, start, mid);
            buildTree(2 * node +2, mid+1, end);
            tree[node] = tree[2 * node +1] + tree[2 * node +2];
        }

        public void update(int index, int val) {
            updateTree(0, 0, n-1, index, val);
            // print();
        }

        private void updateTree(int node, int start, int end, int idx, int val) {
            if (start == end) {
                nums[idx] = val;
                tree[node] = val;
                return;
            }

            int mid = (start + end) / 2;
            if (idx <= mid) {
                updateTree(2 * node +1, start, mid, idx, val); // 왼쪽 자식 업데이트
            } else {
                updateTree(2 * node +2, mid+1, end, idx, val); // 오른쪽 자식 업데이트
            }
            tree[node] = tree[2 * node+1] + tree[2 * node+2]; // 부모 업데이트
        }

        public int sumRange(int left, int right) {
            return sumTreeRange(0, 0, n-1, left, right);
        }

        private int sumTreeRange(int node, int start, int end, int left, int right) {
            if (right <start || end < left) return 0; // 현재 범위에 없으면 0
            if (left<=start && end <= right) return tree[node]; // 노드 범위가 조회 범위에 포함되어있을 때

            int mid = (start+end) / 2;
            int leftTotal = sumTreeRange(2 * node +1, start, mid, left, right); // 왼쪽 자식에서 조회
            int rightTotal = sumTreeRange(2 * node +2, mid+1, end, left, right); // 오른쪽 자식에서 조회
            return leftTotal + rightTotal;
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
}
