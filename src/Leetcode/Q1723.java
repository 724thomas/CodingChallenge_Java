package Leetcode;

import java.util.Arrays;

public class Q1723 {
    class Solution {
        int[] jobs;
        int k;
        int[] threads;

        public int binarySearch() {
            int left = 0, right = 0;
            for (int j : jobs)
                right += j;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (check(mid)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        public boolean check(int mid) {
            threads = new int[k];
            return backtrack(0, mid);
        }

        public boolean backtrack(int idx, int mid) {
            if (idx == jobs.length)
                return true;

            for (int i = 0; i < threads.length; i++) {
                if (threads[i] + jobs[idx] <= mid) {
                    threads[i] += jobs[idx];
                    if (backtrack(idx + 1, mid)) return true;
                    threads[i] -= jobs[idx];
                }
                if (threads[i] == 0) return false;
            }
            return false;
        }

        public void reverseSort() {
            int n = jobs.length;
            Arrays.sort(jobs);
            for (int i = 0; i < jobs.length / 2; i++) {
                int temp = jobs[i];
                jobs[i] = jobs[n - 1 - i];
                jobs[n - 1 - i] = temp;
            }
        }

        public int minimumTimeRequired(int[] jobs, int k) {
            this.jobs = jobs;
            this.k = k;
            reverseSort();
            return binarySearch();
        }
    }
}
