package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q2001 {

    class Solution {
        public long interchangeableRectangles(int[][] rectangles) {
            Map<String, Long> cnt = new HashMap<>();

            for (int[] r : rectangles) {
                int w = r[0], h = r[1];
                int g = gcd(w, h);
                w /= g;
                h /= g;

                String key = w + "#" + h;
                cnt.put(key, cnt.getOrDefault(key, 0L) + 1);
            }

            long ans = 0;
            for (long k : cnt.values()) {
                ans += k * (k - 1) / 2;
            }
            return ans;
        }

        private int gcd(int a, int b) {
            while (b != 0) {
                int t = a % b;
                a = b;
                b = t;
            }
            return a;
        }
    }

}
