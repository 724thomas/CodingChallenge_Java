package Leetcode;

/*
1. 아이디어 :
브루트포스로 풀었습니다.

2. 시간복잡도 :
O( n*m )

3. 자료구조/알고리즘 :
- / 브루트포스
 */

import java.util.ArrayList;
import java.util.List;

public class Q1560 {
    class Solution {
        public List<Integer> mostVisited(int n, int[] rounds) {
            int[] counter = new int[n];
            int start = rounds[0]-1;
            counter[start]++;
            int cmax = 1;

            for (int target : rounds) {
                while (start != target-1) {
                    start = (start+1) % n;
                    counter[start]++;
                    cmax = Math.max(cmax, counter[start]);
                }
            }

            List<Integer> ans = new ArrayList<>();
            for (int i=0; i<n; i++) {
                if (counter[i] == cmax) ans.add(i+1);
            }


            return ans;
        }
    }
}
