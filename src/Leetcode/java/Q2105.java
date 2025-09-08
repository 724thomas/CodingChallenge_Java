package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2105 {
    class Solution {
        public int minimumRefill(int[] plants, int capacityA, int capacityB) {
            int n = plants.length;
            int A = capacityA, B = capacityB;
            int ans = 0;
            for (int i=0; i<n/2; i++) {
                if (plants[i] > A) {
                    ans++;
                    A = capacityA;
                }
                A -= plants[i];

                if (plants[n-i-1] > B) {
                    ans++;
                    B = capacityB;
                }
                B -= plants[n-i-1];
            }

            if (n%2 == 1) {
                int mid = n/2;
                if (A>=B) {
                    if (plants[mid] > A) ans++;
                } else {
                    if (plants[mid] > B) ans++;
                }
            }
            return ans++;
        }
    }
}
