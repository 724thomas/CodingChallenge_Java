package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1952 {
    class Solution {
        public boolean isThree(int n) {
            int count = 0;
            for (int i=2; i<n; i++) {
                if (n%i == 0) count++;
            }
            return count == 1;
        }
    }
}
