package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Q2957 {
    class Solution {
        public int removeAlmostEqualCharacters(String word) {
            int ans = 0;
            for (int i=1; i<word.length(); i++) {
                if (Math.abs(word.charAt(i) - word.charAt(i-1)) <= 1) {
                    ans++;
                    i++;
                }
            }

            return ans;
        }
    }
}
