package Leetcode;

/*
1. 아이디어 :
- n이 1000이하이므로, n**2 시간 복잡도로 풀 수 있다.
- nums를 정렬한 후에, 가장 작은 숫자를 기준으로 다른 숫자들과 비교를 하면서 k들을 구한다.
- 각 k를 하나씩 시도하면서 가능한지 확인한다.
    - 카운터 해시맵을 초기화 한다.
    - nums를 순회하면서, 현재 숫자와 현재 숫자 + diff가 있는지 확인하고 존재하면 counter를 줄이고, ans에 추가한다.

2. 시간복잡도 :
O( nlogn + n**2 )

3. 자료구조/알고리즘 :
해시맵 / -
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q2122 {

    class Solution {
        public int[] recoverArray(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length / 2;

            for (int i = 1; i < nums.length; i++) {
                int diff = nums[i] - nums[0];
                if (diff == 0 || diff % 2 != 0) continue;
                int k = diff / 2;

                Map<Integer, Integer> counter = new HashMap<>();
                for (int num : nums) counter.put(num, counter.getOrDefault(num, 0) + 1);

                int[] ans = new int[n];
                int idx = 0;
                boolean valid = true;

                for (int num : nums) {
                    if (counter.get(num) == 0) continue;

                    if (counter.getOrDefault(num + diff, 0) <= 0) {
                        valid = false;
                        break;
                    }

                    ans[idx++] = num + k;
                    counter.put(num, counter.get(num) - 1);
                    counter.put(num + diff, counter.get(num + diff) - 1);
                }

                if (valid && idx == n) {
                    return ans;
                }
            }

            return nums;
        }
    }

}
