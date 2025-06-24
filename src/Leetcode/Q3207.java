package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3207 {
    class Solution {
        public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
            int cmin = Integer.MAX_VALUE;
            long total = currentEnergy;

            for (int enemyEnergy : enemyEnergies) {
                cmin = Math.min(cmin, enemyEnergy);
                total += enemyEnergy;
            }

            return currentEnergy - cmin < 0 ? 0 : total / cmin - 1;
        }
    }
}
