'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int n = gems.length;
        int kinds = 0;

        Map<String, Integer> counter = new HashMap<>();
        for (String gem:gems){
            if (counter.containsKey(gem)) continue;
            counter.put(gem, 0);
            kinds++;
        }
        if (kinds == 1) return new int[]{1, 1};

        int curr = 0;
        int length = Integer.MAX_VALUE;
        int[] ans = new int[2];

        int left = 0;
        for (int right = 0; right < n; right++) {
            String rightGem = gems[right];
            if (counter.get(rightGem) == 0) curr++;
            counter.put(rightGem, counter.get(rightGem) + 1);

            while (curr == kinds) {
                if (right - left < length) {
                    length = right - left;
                    ans[0] = left + 1;
                    ans[1] = right + 1;
                }
                String leftGem = gems[left];
                counter.put(leftGem, counter.get(leftGem) - 1);
                if (counter.get(leftGem) == 0) curr--;
                left++;
            }
        }
        return ans;
    }
}




'''


