package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3270 {
    class Solution {
        public String getString(int num) {
            String n1 = String.valueOf(num);
            while (n1.length() < 4) {
                n1 = "0" + n1;
            }
            return n1;
        }
        public int generateKey(int num1, int num2, int num3) {
            String n1 = getString(num1);
            String n2 = getString(num2);
            String n3 = getString(num3);

            StringBuilder sb = new StringBuilder();
            for (int i=0; i<4; i++) {
                sb.append( Math.min(
                        Integer.parseInt(n1.charAt(i)+""), Math.min(
                                Integer.parseInt(n2.charAt(i)+""),
                                Integer.parseInt(n3.charAt(i)+""))
                ));
            }

            return Integer.parseInt(sb.toString());
        }
    }
}
