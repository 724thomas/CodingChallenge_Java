package Leetcode.java;

import java.util.HashMap;
import java.util.Map;

public class Q1056 {
    class Solution {
        public boolean confusingNumber(int n) {
            Map<Character, Character> numMap = new HashMap<>();
            numMap.put('0','0');
            numMap.put('1','1');
            numMap.put('6','9');
            numMap.put('8','8');
            numMap.put('9','6');
            String ns = String.valueOf(n);
            StringBuilder sb = new StringBuilder();
            for (int i=ns.length()-1; i>-1; i--){
                char target = ns.charAt(i);
                if (!numMap.containsKey(target)) return false;
                sb.append(numMap.get(target));
            }

            return !sb.toString().equals(ns);
        }
    }
}
