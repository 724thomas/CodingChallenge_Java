package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;

public class Q2126 {
    class Solution {
        public boolean asteroidsDestroyed(int mass, int[] asteroids) {
            Arrays.sort(asteroids);
            long massL = 1L * mass;

            for (int as : asteroids) {
                if (massL < as) return false;
                massL += as;
            }
            return true;
        }
    }
}
