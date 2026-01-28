package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q1797 {
    class AuthenticationManager {
        int TTL;
        Map<String, Integer> map = new HashMap<>();

        public AuthenticationManager(int timeToLive) {
            TTL = timeToLive;
        }

        public void generate(String tokenId, int currentTime) {
            map.put(tokenId, currentTime+TTL);
        }

        public void renew(String tokenId, int currentTime) {
            if (map.containsKey(tokenId)) {
                int expireTime = map.get(tokenId);
                if (expireTime <= currentTime) return;
                map.put(tokenId, currentTime+TTL);
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            int ans = 0;
            for (var entry : map.entrySet()) {
                if (entry.getValue() <= currentTime) continue;
                ans++;
            }
            return ans;
        }
    }

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
}
