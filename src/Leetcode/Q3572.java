package Leetcode;

/*
1. 아이디어 :
- y를 기준으로 내림차순 정렬합니다.
- count가 3이 될 때까지 y값이 중복되지 않는 x값을 선택하여 합을 구합니다.

2. 시간복잡도 :
O( nlogn )

3. 자료구조/알고리즘 :
- / 그리디
 */

import java.util.*;

public class Q3572 {
    class Solution {
        public int maxSumDistinctTriplet(int[] x, int[] y) {
            int n = x.length;

            List<int[]> pairs = new ArrayList<>();
            for (int i=0; i<n; i++) {
                pairs.add(new int[]{y[i], x[i]});
            }
            Collections.sort(pairs, (a, b)->b[0]-a[0]);


            Set<Integer> visited = new HashSet<>();
            int count = 0, ans = 0;

            for (int[] pair : pairs) {
                if (visited.contains(pair[1])) continue;
                visited.add(pair[1]);
                ans+=pair[0];
                if (++count==3) return ans;
            }
            return -1;
        }
    }
}
