package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3114 {
    class Solution {
        public String findLatestTime(String s) {
            StringBuilder sb = new StringBuilder();
            if (s.charAt(0) == '?' && s.charAt(1) == '?') {
                sb.append("11");
            } else if (s.charAt(0) == '?') {
                if (Integer.parseInt((s.charAt(1))+"") >= 2) {
                    sb.append("0").append(s.charAt(1));
                } else {
                    sb.append("1").append(s.charAt(1));
                }
            } else if (s.charAt(1) == '?') {
                if (Integer.parseInt((s.charAt(0))+"") == 0) {
                    sb.append(s.charAt(0)).append("9");
                } else {
                    sb.append(s.charAt(0)).append("1");
                }
            } else {
                sb.append(s.charAt(0) + "" + s.charAt(1));
            }

            sb.append(":");

            if (s.charAt(3) == '?' && s.charAt(4) == '?') {
                sb.append("59");
            } else if (s.charAt(3) == '?') {
                sb.append("5").append(s.charAt(4));
            } else if (s.charAt(4) == '?') {
                sb.append(s.charAt(3)).append("9");
            } else {
                sb.append(s.charAt(3) + "" + s.charAt(4));
            }

            return sb.toString();
        }
    }
}
