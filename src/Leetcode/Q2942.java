package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q2942 {
    class Solution {
        public List<Integer> findWordsContaining(String[] words, char x) {
            List<Integer> ans = new ArrayList<>();
            for (int i=0; i<words.length; i++) {
                for (char c : words[i].toCharArray()) {
                    if (c==x) {
                        ans.add(i);
                        break;
                    }
                }
            }
            return ans;
        }
    }
}
