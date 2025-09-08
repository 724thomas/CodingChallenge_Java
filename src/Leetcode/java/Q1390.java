package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q1390 {
    class Solution {
        Map<Integer, Integer> cache = new HashMap<>();
        public int divisors(int num) {
            if (Math.sqrt(num) == (int)Math.sqrt(num)) return 0;
            int count = 0, total = 0;
            for (int i=1; i<Math.sqrt(num); i++) {
                if (num % i == 0) {
                    count+=2;
                    total += i + num/i;
                }
                if (count>4) return 0;
            }
            if (count==4) cache.put(num, total);
            return count==4? total : 0;
        }
        public int sumFourDivisors(int[] nums) {
            int ans = 0;
            for (int num : nums) {
                ans += cache.containsKey(num)? cache.get(num) : divisors(num);
            }
            return ans;
        }
    }
}
