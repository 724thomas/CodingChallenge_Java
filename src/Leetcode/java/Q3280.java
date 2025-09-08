package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3280 {
    class Solution {
        public String convertDateToBinary(String date) {
            StringBuilder sb = new StringBuilder();
            String[] d = date.split("-");
            sb.append(Integer.toBinaryString(Integer.parseInt(d[0]))).append("-");
            sb.append(Integer.toBinaryString(Integer.parseInt(d[1]))).append("-");
            sb.append(Integer.toBinaryString(Integer.parseInt(d[2])));
            return sb.toString();
        }
    }
}
