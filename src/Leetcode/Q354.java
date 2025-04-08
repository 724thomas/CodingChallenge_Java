package Leetcode;

/*
1. 아이디어 :
Longest Increase Subsequence 문제입니다.
2차 배열을 오름차순, 내림차순 순으로 정렬 합니다. ( y_i < y_j 이면, x_i < x_j가 됩니다.)
이후 y좌표를 기준으로 LIS를 구합니다.
이때 y좌표가 같을 경우 내림차순으로 정렬하여 같은 y좌표를 가지는 envelope는 하나만 선택할 수 있도록 합니다.

2. 시간복잡도 :
O( nlogn )

3. 자료구조/알고리즘 :
- / 정렬, 이분탐색
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q354 {
    class Solution {
        public int bisectLeft(List<Integer> arr, int target) {
            int left = 0, right = arr.size();
            while (left<right) {
                int mid = (left+right) / 2;
                if (arr.get(mid) < target) {
                    left = mid+1;
                } else {
                    right = mid;
                }
            }
            return left;
        }

        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, (a, b) -> {
                if (a[0] == b[0]) return b[1]-a[1];
                return a[0]-b[0];
            });

            for (var a : envelopes) System.out.print(Arrays.toString(a));
            System.out.println();

            List<Integer> lis = new ArrayList<>();
            for (int[] cord : envelopes) {
                int x = cord[0], y = cord[1];
                int index = bisectLeft(lis, y);
                if (index >= lis.size()) {
                    lis.add(y);
                } else {
                    lis.set(index, y);
                }
                System.out.println(lis);
            }

            return lis.size();
        }
    }
}
