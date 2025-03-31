package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q781 {
    class Solution {
        public int numRabbits(int[] answers) {
            Map<Integer, Integer> counter = new HashMap<>();
            for (int num : answers) {
                counter.put(num+1, counter.getOrDefault(num+1, 0)+1);
            }

            int ans = 0;
            for (var entry : counter.entrySet()) {
                int key = entry.getKey(), val = entry.getValue();
                ans += key * (val/key);
                if (val % key > 0) ans += key;
            }
            return ans;

        }
    }
}
