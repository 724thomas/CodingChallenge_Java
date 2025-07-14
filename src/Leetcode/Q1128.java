package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1128 {
    class Solution {
        public int numEquivDominoPairs(int[][] dominoes) {
            int n = dominoes.length, ans = 0;
            Map<String, Integer> map = new HashMap<>();

            for (int[] d : dominoes) {
                Arrays.sort(d);
                String key = d[0] + "-" + d[1];
                map.put(key, map.getOrDefault(key, 0)+1);
            }

            for (int count : map.values()) {
                ans += count * (count-1) / 2;
            }

            return ans;
        }
    }
}
