package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2808 {
    class Solution {
        public int minimumSeconds(List<Integer> nums) {
            int n = nums.size();
            Map<Integer, List<Integer>> positions = new HashMap<>();
            Map<Integer, Integer> maxDist = new HashMap<>();

            for (int i=0; i<n; i++) {
                int key = nums.get(i);
                if (!positions.containsKey(key)) {
                    positions.put(key, new ArrayList<>());
                    positions.get(key).add(i);
                } else {
                    List<Integer> indexes = positions.get(key);
                    maxDist.put(key, Math.max(maxDist.getOrDefault(key, 0), i-indexes.getLast()-1));
                    indexes.add(i);
                }
            }

            int ans = Integer.MAX_VALUE;
            for (var entry : positions.entrySet()) {
                int key = entry.getKey();
                List<Integer> indexes = entry.getValue();
                int cmax = Math.max(maxDist.getOrDefault(key, 0), indexes.get(0) + n - indexes.getLast()-1);
                cmax = (cmax+1)/2;
                ans = Math.min(ans, cmax);
            }

            return ans;
        }
    }
}
