package Leetcode;

public class Q186 {
    class Solution {
        public void swap(char[] s, int start, int end){
            end--;
            int length = end - start;
            while (start < end) {
                char temp = s[start];
                s[start] = s[end];
                s[end] = temp;
                start ++;
                end--;
            }
        }

        public void reverseWords(char[] s) {
            swap(s, 0, s.length);
            int start = 0;
            for (int end = 0; end < s.length+1; end++) {
                if (end == s.length || s[end] == ' ') {
                    swap(s, start, end);
                    start = end+1;
                }
            }
        }
    }
}
