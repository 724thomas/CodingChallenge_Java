package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q49 {
    class Solution {
        public String sortStr(String s) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            StringBuilder sb = new StringBuilder();
            for (char c : chars) sb.append(c);
            return sb.toString();
        }


        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String s1 : strs) {
                String s2 = sortStr(s1);
                map.putIfAbsent(s2, new ArrayList<>());
                map.get(s2).add(s1);
            }

            List<List<String>> ans = new ArrayList<>();
            for (var values : map.values()) ans.add(values);
            return ans;
        }
    }
}
