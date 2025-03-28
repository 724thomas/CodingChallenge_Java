package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashSet;
import java.util.Set;

public class Q3477 {
    class Solution {
        public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
            int n = fruits.length;
            Set<Integer> visited = new HashSet<>();
            for (int fruit : fruits) for (int i = 0; i<n; i++) {
                if (!visited.contains(i) && baskets[i] >= fruit) {
                    visited.add(i);
                    break;
                }
            }
            return n - visited.size();
        }
    }
}
