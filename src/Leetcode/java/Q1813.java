package Leetcode.java;

public class Q1813 {
    class Solution {
        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            String[] s1 = sentence1.split(" "), s2 = sentence2.split(" ");
            if (s1.length > s2.length) {
                String[] temp = s1;
                s1 = s2;
                s2 = temp;
            }
            int i = 0, j = 0, n = s1.length, m =s2.length;
            while (i < n && s1[i].equals(s2[i])) i++;
            while (j < n && s1[n - 1 - j].equals(s2[m - 1 - j])) j++;
            return (i + j >= n) || (i + j >= m);
        }
    }
}
