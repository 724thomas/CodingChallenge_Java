package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q2904 {
    class Solution {
        List<Integer> idxs = new ArrayList<>();
        String s;

        public String formString(int startIdx, int endIdx) {
            StringBuilder sb = new StringBuilder();
            for (int i=startIdx; i<=endIdx; i++) {
                sb.append( s.charAt(i));
            }
            return sb.toString();
        }

        public String shortestBeautifulSubstring(String s, int k) {
            this.s = s;

            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '1') idxs.add(i);
            }
            int longest = Integer.MAX_VALUE;
            String ans = "";

            for (int i=0; i<idxs.size()-k+1; i++) {
                int startIdx = idxs.get(i), endIdx = idxs.get(i+k-1);
                int length = endIdx - startIdx;
                String temp = formString(startIdx, endIdx);
                if (length < longest) {
                    ans = temp;
                    longest = length;
                } else if (length == longest) {
                    if (temp.compareTo(ans) < 0) ans = temp;
                }
            }

            return ans;
        }
    }
}
