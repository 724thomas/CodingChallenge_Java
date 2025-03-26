package Leetcode;

/*
1. 아이디어 :
누적합을 사용합니다
값에 따라 해시맵에 저장합니다.
해시맵에서 num 기준으로 왼쪽과 오른쪽을 나눠서 계산합니다.

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
해시맵 / 누적합
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2615 {
    class Solution {
        public long[] distance(int[] nums) {
            Map<Integer, List<Integer>> idxsMap = new HashMap<>();
            int n = nums.length;
            long[] ans = new long[n];

            for (int i=0; i<n; i++) {
                int num = nums[i];
                idxsMap.putIfAbsent(num, new ArrayList<>());
                idxsMap.get(num).add(i);
            }

            for (List<Integer> idxs : idxsMap.values()) {
                int size = idxs.size();
                long[] prefix = new long[size];
                prefix[0] = idxs.get(0);

                for (int i = 1; i<size; i++) {
                    prefix[i] = prefix[i-1] + idxs.get(i);
                }

                for (int i=0; i<size; i++) {
                    int idx = idxs.get(i);
                    long left = 0;
                    if (i > 0) {
                        left = (long)i * idx - prefix[i-1];
                    }

                    long right = (prefix[size-1] - prefix[i] - (long)(size - i - 1) * idx);
                    ans[idx] = left + right;
                }
            }
            return ans;
        }
    }
}
