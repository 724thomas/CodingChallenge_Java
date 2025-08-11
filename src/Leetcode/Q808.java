package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q808 {
    class Solution {
        Double[][] cache;
        private double dfs(int A, int B) {
            if (A<=0 && B>0) return 1;
            if (A<=0 && B<=0) return 0.5;
            if (A>=0 && B<=0) return 0;
            if (cache[A][B] != null) return cache[A][B];

            double total = 0;
            total += dfs(A-4, B-0);
            total += dfs(A-3, B-1);
            total += dfs(A-2, B-2);
            total += dfs(A-1, B-3);
            cache[A][B] = total/4;
            return total/4;
        }
        public double soupServings(int n) {
            if (n>=4500) return 1;
            cache = new Double[n/25+2][n/25+2];
            return dfs((int)Math.ceil(n/25.0), (int)Math.ceil(n/25.0));
        }
    }
}
