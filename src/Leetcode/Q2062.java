package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q2062 {
    class Solution {
        public int countSub(String word) {
            int total = 0;
            Set<Character> vowels = new HashSet<>();
            int count = 0;
            for (int i=0; i<word.length(); i++) {
                vowels.clear();
                count = 0;
                for (int j=i; j<word.length(); j++) {
                    count += (vowels.add(word.charAt(j))) ? 1 : 0;
                    if (count==5) total++;
                }
            }
            return total;
        }

        public int countVowelSubstrings(String word) {
            int ans = 0;
            Set<Character> vowels = new HashSet<>();
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');

            StringBuilder sb = new StringBuilder();
            for (int i=0; i<word.length(); i++) {
                char target = word.charAt(i);
                if (!vowels.contains(target)) {
                    if (sb.toString().equals("")) continue;
                    ans += countSub(sb.toString());
                    sb = new StringBuilder();
                } else {
                    sb.append(target);
                }
            }
            if (!sb.toString().equals("")) ans += countSub(sb.toString());
            return ans;
        }
    }
}
