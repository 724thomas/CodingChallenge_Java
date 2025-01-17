package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q3120 {
    class Solution {
        public int numberOfSpecialChars(String word) {
            Set<Character> visited = new HashSet<>();
            Set<Character> ans = new HashSet<>();
            for (char c : word.toCharArray()) {
                visited.add(c);
                if (Character.isLowerCase(c)) {
                    if (visited.contains(Character.toUpperCase(c))) ans.add(c);
                } else {
                    if (visited.contains(Character.toLowerCase(c))) ans.add(Character.toLowerCase(c));
                }
            }

            return ans.size();
        }
    }
}
