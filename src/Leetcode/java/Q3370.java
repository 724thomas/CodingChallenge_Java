package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3370 {
    class Solution {
        public int smallestNumber(int n) {
            StringBuilder sb = new StringBuilder();
            sb.append("1");
            while (Integer.parseInt(sb.toString(), 2) < n)
                sb.append("1");
            return Integer.parseInt(sb.toString(), 2);
        }
    }
}
