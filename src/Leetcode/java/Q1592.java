package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q1592 {
    class Solution {
        public String reorderSpaces(String text) {
            int count = 0;
            boolean prevChar = true;

            List<String> words = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            for (char c : text.toCharArray()) {
                if (c == ' ') {
                    if (prevChar) {
                        prevChar = false;
                        if (!sb.isEmpty()) {
                            words.add(sb.toString());
                            sb = new StringBuilder();
                        }

                    }
                    count++;
                } else {
                    sb.append(c);
                    prevChar = true;
                }
            }
            if (!sb.isEmpty()) words.add(sb.toString());

            if (words.size()==1) {
                return words.get(0) + " ".repeat(count);
            }

            int equalGaps = count / (words.size()-1);
            int remain = count % (words.size()-1);

            sb = new StringBuilder();
            for (int i=0; i<words.size()-1; i++) {
                sb.append(words.get(i));
                sb.append(" ".repeat(equalGaps));
            }
            sb.append(words.get(words.size()-1)).append(" ".repeat(remain));

            return sb.toString();
        }
    }
}
