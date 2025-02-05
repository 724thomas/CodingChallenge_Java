package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
1. 아이디어 :
prefixSum을 통해 풀 수 있습니다.
왼쪽부터 오른쪽으로 List를 만들어서, List의 마지막 원소보다 값이 커지면, list의 원소를 현재 값으로 초기화합니다.
근데 list가 필요없고 단순히 길이만 알면되기때문에 마지막 숫자와, 현재 카운트를 사용했습니다.
왼쪽->오른쪽, 오른쪽->왼쪽을 모두 순회하고, 두 값모두 k보다 크거나 같으면 해당 idx를 추가.

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
배열 / 누적합
 */

public class Q2420 {
    class Solution {
        public List<Integer> goodIndices(int[] nums, int k) {
            int n = nums.length;
            int[][] ansList = new int[n+1][2];

            int lastNum = Integer.MAX_VALUE;
            int count = 0;
            for (int i=0; i<n; i++) {
                if (lastNum < nums[i]) count = 0;
                lastNum = nums[i];
                ansList[i+1][0] = ++count;
            }

            lastNum = Integer.MAX_VALUE;
            count = 0;
            for (int i=n-1; i>0; i--) {
                if (lastNum < nums[i]) count=0;
                lastNum = nums[i];
                ansList[i-1][1] = ++count;
            }

            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i<ansList.length; i++) {
                int[] a = ansList[i];
                if (a[0] >= k && a[1] >= k) ans.add(i);
            }
            return ans;
        }
    }
}
