package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q2938 {
    class Solution {
        public long minimumSteps(String s) {
            int n = s.length();
            List<Integer> zeros = new ArrayList<>();
            char[] ss = new char[n];
            for (int i=0; i<n; i++) {
                if (s.charAt(i) == '0') zeros.add(i);
                ss[i] = s.charAt(i);
            }
            if (zeros.size() == n || zeros.size() == 0) return 0;

            int idx = 0;
            long ans = 0;
            for (int i=0; i<n; i++) {
                if (ss[i] == '1' && idx<zeros.size()) {
                    int zero = zeros.get(idx);
                    ans += zero - i;
                    ss[zero] = '1';
                }
                idx++;
            }

            return ans;
        }
    }
}
