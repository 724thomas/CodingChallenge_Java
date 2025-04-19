package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q941 {
    class Solution {
        public boolean validMountainArray(int[] arr) {
            int n = arr.length;
            if (n < 3) return false;
            int cmax = -1;
            int cidx = -1;

            for (int i=0; i<n; i++) {
                int num = arr[i];
                if (num >cmax) {
                    cmax = num;
                    cidx = i;
                } else if (num == cmax) return false;
            }

            if (cidx == 0 || cidx == n-1) return false;

            for (int i = cidx; i>0; i--) {
                if (arr[i-1] >= arr[i]) return false;
            }

            for (int i = cidx; i<n-1; i++) {
                if (arr[i] <= arr[i+1]) return false;
            }

            return true;
        }
    }
}
