package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1894 {
    class Solution {
        public int chalkReplacer(int[] chalk, int k) {
            int n = chalk.length;
            long total = 0;
            for (int c : chalk) total+=c;

            k %= total;

            for (int i=0; i<n; i++) {
                k -= chalk[i];
                if (k<0) return i;
            }

            return -1;
        }
    }
}
