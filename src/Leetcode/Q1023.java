package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q1023 {
    class Solution {
        public boolean check(String q, String p) {
            int qi = 0, pi = 0;

            for (int i=0; i<q.length(); i++) {
                if (pi!=p.length()) {
                    if (q.charAt(i) == p.charAt(pi)) {
                        pi++;
                    } else if (Character.isUpperCase(q.charAt(i)) && q.charAt(i) != p.charAt(pi)) return false;
                } else {
                    if (Character.isUpperCase(q.charAt(i))) return false;
                }
            }


            return pi == p.length();
        }
        public List<Boolean> camelMatch(String[] queries, String pattern) {
            List<Boolean> ans = new ArrayList<>();
            for (String q : queries) {
                ans.add(check(q, pattern));
            }

            return ans;
        }
    }
}
