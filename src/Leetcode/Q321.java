package Leetcode;

/*
1. 아이디어 :
k를 1:k-1, ... k-1:1로 나누고, 각 경우에 대해 스택으로 최대값을 구한다.
그 후, 두 스택을 합쳐서 최대값을 구한다.


2. 시간복잡도 :
O( O(k * (n + m + k*k/2) + n)

3. 자료구조/알고리즘 :
스택 / 그리디
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Q321 {
    class Solution {
        int[] nums1, nums2;
        int n, m, k;

        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            n = nums1.length;
            m = nums2.length;
            this.k = k;

            int maxLeft = Math.min(k, n);
            int minLeft = Math.max(0, k-m);
            String ans = "";

            for (int i=minLeft; i<=maxLeft; i++) { // O(k)
                int leftSize = i, rightSize = k-i;
                int[] dq1 = createStack(nums1, leftSize); // O(n)
                int[] dq2 = createStack(nums2, rightSize); // O(m)
                String candid = merge(dq1, dq2);    // O(k*k/2)
                if (ans.compareTo(candid) < 0) {
                    ans = candid;
                }
            }

            return toList(ans); // O(n)
        }

        public int[] toList(String s) { // O(n)
            int n = s.length();
            int[] ans = new int[n];
            for (int i =0; i<n; i++) {
                ans[i] = Integer.parseInt(s.charAt(i)+"");
            }
            return ans;
        }

        public int[] createStack(int[] nums, int size) { // O(n)
            int n = nums.length;
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i=0; i<n; i++) {
                int curr = nums[i];
                while (!stack.isEmpty() && stack.peekLast() < curr && stack.size() + (n-i-1) >= size) {
                    stack.pollLast();
                }
                stack.addLast(nums[i]);
            }
            int[] ans = new int[size];
            for (int i=0; i<size; i++) {
                ans[i] = stack.pollFirst();
            }
            return ans;
        }

        public String merge(int[] dq1, int[] dq2) { // O(k**2)
            StringBuilder sb = new StringBuilder();
            int left = 0, right = 0;
            for (int i=0; i<k; i++) {
                if (bigger(dq1, left, dq2, right)) {
                    sb.append(dq1[left++]);
                } else {
                    sb.append(dq2[right++]);
                }
            }
            return sb.toString();
        }

        public boolean bigger(int[] dq1, int left, int[] dq2, int right) { // O(k/2)
            int n = dq1.length, m = dq2.length;
            while ( left<n && right<m && dq1[left] == dq2[right]) {
                left++;
                right++;
            }
            if (right==m) return true;
            if (left==n) return false;
            return dq1[left] > dq2[right];
        }

    }
}
