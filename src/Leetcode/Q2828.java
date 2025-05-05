package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.List;

public class Q2828 {
    class Solution {
        public boolean isAcronym(List<String> words, String s) {
            if (words.size() != s.length()) return false;
            for (int i=0; i<s.length(); i++) {
                if (words.get(i).charAt(0) != s.charAt(i)) return false;
            }
            return true;
        }
    }
}
