package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q3005 {
    class Solution {
        public int maxFrequencyElements(int[] nums) {
            Map<Integer, Integer> counter = new HashMap<>();
            for (int num : nums) counter.put(num, counter.getOrDefault(num, 0)+1);

            int maxFreq = 0;
            int ans = 0;
            for (var entry : counter.entrySet()) {
                int key = entry.getKey(), freq = entry.getValue();
                if (maxFreq < freq) {
                    maxFreq = freq;
                    ans = freq;
                } else if (maxFreq == freq) {
                    ans+=freq;
                }
            }

            return ans;
        }
    }
}
