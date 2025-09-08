package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q3412 {
    class Solution {
        public char getMirror(char c) {
            return (char) ('z' - (c - 'a'));
        }

        public long calculateScore(String s) {
            long ans = 0;

            Map<Character, Stack<Integer>> idxMap = new HashMap<>();

            for (int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                char mc = getMirror(c);
                idxMap.putIfAbsent(c, new Stack<>());
                idxMap.putIfAbsent(mc, new Stack<>());

                if (!idxMap.get(mc).isEmpty()) {
                    ans += i-idxMap.get(mc).pop();

                } else {

                    idxMap.get(c).add(i);
                }
            }
            return ans;
        }
    }
}
