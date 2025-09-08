package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1689 {
    class Solution {
        public int minPartitions(String n) {
            int cmax = 0;
            for (int i=0; i<n.length(); i++) {
                cmax = Math.max(cmax, n.charAt(i)-'0');
            }
            return cmax;
        }
    }
}
