package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashSet;
import java.util.Set;

public class Q2682 {
    class Solution {
        public int[] circularGameLosers(int n, int k) {
            Set<Integer> visited = new HashSet<>();
            visited.add(0);
            int curr = 0, round = 0;

            while (visited.add(curr = (curr + k * (++round)) % n));

            int[] ans = new int[n-visited.size()];
            int idx = 0;
            for (int i=0; i<n; i++) {
                if (!visited.contains(i)) ans[idx++] = i+1;
            }
            return ans;
        }
    }
}
