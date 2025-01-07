package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q3136 {
    class Solution {
        public boolean isValid(String word) {
            char[] cword = word.toCharArray();
            int countVowel = 0;
            int countConsonant = 0;
            Set<Character> vowels = new HashSet<>();
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');

            if (word.length()<3) return false;

            for (char ch : cword) {
                char c = Character.toLowerCase(ch);

                if (!Character.isAlphabetic(c) && !Character.isDigit(c)) return false;

                if (Character.isAlphabetic(c)) {
                    if (vowels.contains(c)) countVowel++; else countConsonant++;
                }
            }

            if (countVowel == 0 || countConsonant == 0) return false;

            return true;
        }
    }
}
