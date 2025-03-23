package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1534 {
    class Solution {
        public int countGoodTriplets(int[] arr, int a, int b, int c) {
            int n = arr.length, ans = 0;
            for (int i=0; i<n; i++) for (int j=i+1; j<n; j++) for (int k=j+1; k<n; k++) {
                if (Math.abs(arr[i] - arr[j]) <= a
                        && Math.abs(arr[j] - arr[k]) <= b
                        && Math.abs(arr[i] - arr[k]) <= c) {
                    ans++;
                }
            }
            return ans;
        }
    }
}
