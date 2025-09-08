package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q1087 {
    class Solution {
        Map<Integer, List<Character>> map = new HashMap<>();
        List<String> ans = new ArrayList<>();

        public String[] expand(String s) {
            initMap(s);
            backtrack(new ArrayList<>(), 0, map.size());
            return convert();
        }

        private String joinString(List<Character> curr) {
            StringBuilder sb = new StringBuilder();
            for (char c : curr) {
                sb.append(c);
            }
            return sb.toString();
        }

        private void backtrack(List<Character> curr, int idx, int n) {
            if (curr.size() == n) {
                ans.add(joinString(curr));
                return;
            }

            for (char c : map.get(idx)) {
                curr.add(c);
                backtrack(curr, idx+1, n);
                curr.remove(curr.size()-1);
            }
        }

        private void initMap(String s) {
            int idx = 0;
            boolean p = false;
            for (char c : s.toCharArray()) {
                if (c==',') continue;
                if (c == '{') {
                    p = true;
                } else if (c == '}') {
                    p = false;
                    idx++;
                } else {
                    map.putIfAbsent(idx, new ArrayList<>());
                    map.get(idx).add(c);
                    if (!p) idx++;
                }
            }
        }

        private String[] convert() {
            Collections.sort(ans);
            int size = ans.size();
            String[] ans2 = new String[size];
            for (int i=0; i<size; i++) {
                ans2[i] = ans.get(i);
            }
            return ans2;
        }
    }
}
