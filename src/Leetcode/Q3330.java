package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3330 {
    class Solution {
        public int possibleStringCount(String word) {
            int count = 1, ans = 0;
            char prev = '-';
            for (char c : word.toCharArray()) {
                if (c == prev) {
                    count++;
                } else {
                    ans+=count-1;
                    prev = c;
                    count = 1;
                }
            }
            ans += count;
            return ans;

        }
    }
}
