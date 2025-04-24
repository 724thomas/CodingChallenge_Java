package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2566 {
    class Solution {
        public int minMaxDifference(int num) {
            String snum = String.valueOf(num);
            int n = snum.length();

            StringBuilder maxNum = new StringBuilder();
            int not9 = -1;
            for (int i=0; i<n; i++) {
                if (snum.charAt(i) != '9') {
                    not9 = snum.charAt(i);
                    break;
                }
            }
            for (int i=0; i<n; i++) {
                if (snum.charAt(i) != not9) {
                    maxNum.append(snum.charAt(i));
                } else {
                    maxNum.append("9");
                }
            }

            StringBuilder minNum = new StringBuilder();
            for (int i=0; i<n; i++) {
                if (snum.charAt(i) == snum.charAt(0)) {
                    minNum.append('0');
                } else {
                    minNum.append(snum.charAt(i));
                }
            }

            return Integer.parseInt(maxNum.toString()) - Integer.parseInt(minNum.toString());
        }
    }
}
