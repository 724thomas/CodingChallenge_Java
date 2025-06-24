package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3582 {
    class Solution {
        public String generateTag(String caption) {
            caption = caption.strip();
            String[] words = caption.split(" ");
            words[0] = "#"+words[0];

            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                if (word.length() == 0) continue;
                sb.append(Character.toUpperCase(word.charAt(0)));

                for (int i=1; i<word.length(); i++) {
                    sb.append(Character.toLowerCase(word.charAt(i)));
                    if (sb.length() == 100) return sb.toString();
                }
            }
            return sb.toString();
        }
    }
}
