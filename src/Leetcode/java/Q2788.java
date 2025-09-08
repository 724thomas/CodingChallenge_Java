package Leetcode.java;

import java.util.ArrayList;
import java.util.List;

public class Q2788 {
    class Solution {
        public List<String> splitWordsBySeparator(List<String> words, char separator) {
            List<String> ans = new ArrayList<>();
            StringBuilder sb;
            for (String word: words) {
                sb = new StringBuilder();
                for (char c : word.toCharArray()) {
                    if (c == separator) {
                        if (sb.length() != 0) {
                            ans.add(sb.toString());
                            sb = new StringBuilder();
                        }
                    } else {
                        sb.append(c+"");
                    }
                }
                if (sb.length()!=0) ans.add(sb.toString());
            }
            return ans;
        }
    }
}
