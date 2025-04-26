package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q1138 {
    class Solution {
        int[] curr = {0,0};
        public String getCord(int[] e) {
            StringBuilder sb = new StringBuilder();
            int x = e[0], y = e[1];

            while (y < curr[1]) {
                sb.append("L");
                curr[1] -= 1;
            }

            while (x < curr[0]) {
                sb.append("U");
                curr[0] -= 1;
            }

            while (curr[1] < y) {
                sb.append("R");
                curr[1] += 1;
            }

            while (curr[0] < x) {
                sb.append("D");
                curr[0] += 1;
            }

            return sb.toString();
        }
        public String alphabetBoardPath(String target) {
            Map<Character, int[]> cords = new HashMap<>();
            for (int i=0; i<5; i++) {
                for (int j=0; j<5; j++) {
                    Character key = (char) ('a' + (i*5 + j));
                    cords.put(key, new int[]{i,j});
                }
            }
            cords.put('z', new int[]{5,0});

            StringBuilder sb = new StringBuilder();
            for (char c : target.toCharArray()) {
                sb.append( getCord( cords.get(c))).append("!");
            }
            return sb.toString();
        }
    }
}
