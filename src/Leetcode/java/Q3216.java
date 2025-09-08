package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3216 {
    class Solution {
        public String getSmallestString(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<s.length()-1; i++) {
                char left = s.charAt(i), right = s.charAt(i+1);
                int lval = Integer.parseInt(left+""), rval = Integer.parseInt(right+"");
                if ((lval % 2 == rval % 2) && (left > right)) {
                    sb.append(right).append(left);
                    break;
                }
                sb.append(left);
            }

            for (int i=sb.toString().length(); i<s.length(); i++) {
                sb.append(s.charAt(i));
            }

            return sb.toString();
        }
    }
}
