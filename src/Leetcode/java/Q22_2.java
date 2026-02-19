package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q22_2 {
    class Solution {
        List<String> ans = new ArrayList<>();
        List<Character> curr = new ArrayList<>();
        int n;

        public List<String> generateParenthesis(int n) {
            this.n = n;
            backtrack(0, 0);
            return ans;
        }

        public void backtrack(int open, int close) {
            if (open == n && close == n) {
                ans.add(listToString(curr));
                return;
            }

            if (open < n) {
                curr.add('(');
                backtrack(open+1, close);
                curr.remove(curr.size()-1);
            }

            if (close < open) {
                curr.add(')');
                backtrack(open, close+1);
                curr.remove(curr.size()-1);
            }
        }

        public String listToString(List<Character> list) {
            StringBuilder sb = new StringBuilder();
            for (char c : list) {
                sb.append(c);
            }
            return sb.toString();
        }
    }
}
