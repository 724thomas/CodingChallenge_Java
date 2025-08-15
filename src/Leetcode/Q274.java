package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q274 {
    class Solution {
        int[] citations;
        int n;
        public int binarySearch() {
            int left = 0, right = n;

            while (left<=right) {
                int mid = left + (right-left)/2;
                if (check(mid) <= 0) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
            return right;
        }

        public int check(int target) { // -1 : low, 0 : found, 1 : high
            int total = 0;
            for (int citation : citations) {
                if (citation >= target) total++;
            }
            return (target < total)? -1 : (target == total)? 0 : 1;

        }

        public int hIndex(int[] citations) {
            this.citations = citations;
            n = citations.length;
            return binarySearch();
        }
    }
}
