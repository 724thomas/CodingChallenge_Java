package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q2325 {
    class Solution {
        public String decodeMessage(String key, String message) {
            Map<Character, Character> map = new HashMap<>();

            char curr = 'a';
            for (char c : key.toCharArray()) {
                if (map.containsKey(c) || c == ' ') continue;
                map.put(c, curr);
                curr = (char)(curr+1);
            }

            StringBuilder sb = new StringBuilder();
            for (char c : message.toCharArray()) {
                sb.append(map.getOrDefault(c, c));
            }

            return sb.toString();
        }
    }
}
