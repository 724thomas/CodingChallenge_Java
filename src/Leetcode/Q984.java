package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q984 {
    class Solution {
        public String strWithout3a3b(int a, int b) {
            char bigger = 'a';
            int bigVal = a;
            char smaller = 'b';
            int smallVal = b;
            if (b>a) {
                bigger = 'b';
                bigVal = b;
                smaller = 'a';
                smallVal = a;
            }

            StringBuilder sb = new StringBuilder();
            while (bigVal > 0 || smallVal > 0) {
                if (bigVal > 0) {
                    sb.append(bigger);
                    bigVal--;
                    if (bigVal > smallVal) {
                        sb.append(bigger);
                        bigVal--;
                    }
                }
                if (smallVal > 0) {
                    sb.append(smaller);
                    smallVal--;
                }
            }

            return sb.toString();

        }
    }
}
