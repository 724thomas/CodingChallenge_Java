package Leetcode.java;

/*
1. 아이디어 :
- 각 캐릭터마다 짝이 있는 갯수 만큼 ans에 더해줍니다
- 홀수개가 하나라도 있다면 1개 더해줍니다.

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
해시맵

 */

import java.util.HashMap;
import java.util.Map;

public class Q409 {
    class Solution {
        public int longestPalindrome(String s) {
            int n = s.length();
            Map<Character, Integer> counter = new HashMap<>();
            int odds = 0;

            for (int i=0; i<n; i++) {
                char c = s.charAt(i);
                counter.put(c, counter.getOrDefault(c, 0)+1);

                if (counter.get(c) % 2 == 1) {
                    odds++;
                } else {
                    odds--;
                }
            }

            int ans = 0;
            for (var entry : counter.entrySet()) {
                int count = entry.getValue();
                ans += count / 2 * 2;
            }

            if (odds > 0) {
                ans ++;
            }
            return ans;
        }
    }
}
