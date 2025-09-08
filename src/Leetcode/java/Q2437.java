package Leetcode.java;

/*
1. 아이디어 :
백트래킹을 사용합니다.
모든 조합을 구한뒤에, 유효한 시간인지 확인합니다.

2. 시간복잡도 :
O( 10^5 )

3. 자료구조/알고리즘 :
해시셋 / 백트래킹
 */

import java.util.HashSet;
import java.util.Set;

public class Q2437 {
    class Solution {
        Set<String> candids = new HashSet<>();
        public boolean isValid(String time) {
            String[] times = time.split(":");
            int hour = Integer.parseInt(times[0]), minite = Integer.parseInt(times[1]);
            if (hour >= 24 || minite >= 60) return false;
            return true;
        }

        public void backtrack(String time, int idx, StringBuilder curr) {
            if (idx == 5) {
                candids.add(curr.toString());
                return;
            }
            char c = time.charAt(idx);
            if (c == '?') {
                for (int i=0; i<10; i++) {
                    curr.append(i);
                    backtrack(time, idx+1, curr);
                    curr.deleteCharAt(curr.length()-1);
                }
            } else {
                curr.append(c);
                backtrack(time, idx+1, curr);
                curr.deleteCharAt(curr.length()-1);
            }
        }

        public int countTime(String time) {
            backtrack(time, 0, new StringBuilder());
            int ans = 0;
            for (String candid : candids) {
                if (isValid(candid)) ans++;
            }
            return ans;

        }
    }
}
