package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3477_2 {
    class Solution {
        public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
            int ans = 0;
            int n = fruits.length, m = baskets.length;
            for (int fruit : fruits) {
                boolean placed = false;
                for (int i=0; i<m; i++) {
                    if (fruit <= baskets[i]) {
                        baskets[i] = 0;
                        placed = true;
                        break;
                    }
                }
                if (!placed) ans++;
            }
            return ans;
        }
    }
}
