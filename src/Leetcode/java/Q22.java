package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q22 {
    class Solution {
        public String formString(List<Character> chars) {
            StringBuilder sb = new StringBuilder();
            for (char c : chars) sb.append(c);
            return sb.toString();
        }

        List<String> ans = new ArrayList<>();
        public void dfs(List<Character> curr, int opened, int closed, int n) {
            if (opened == n && closed == n) {
                ans.add(formString(curr));
                return;
            }

            if (opened == n) {
                curr.add(')');
                dfs(curr, opened, closed+1, n);
                curr.remove(curr.size()-1);
            } else if (opened > closed) {
                curr.add('(');
                dfs(curr, opened+1, closed, n);
                curr.remove(curr.size()-1);
                curr.add(')');
                dfs(curr, opened, closed+1, n);
                curr.remove(curr.size()-1);
            } else if (opened == closed) {
                curr.add('(');
                dfs(curr, opened+1, closed, n);
                curr.remove(curr.size()-1);
            }
        }
        public List<String> generateParenthesis(int n) {
            dfs(new ArrayList<>(), 0, 0, n);
            return ans;
        }
    }
}
