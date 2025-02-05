package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
1. 아이디어 :
Longest Increasing Subsequence 문제입니다. (정확히는 Longest non-decreasing Subsequence).
LIS를 사용할때 dp를 사용하면 n**2 시간복잡도가 되기때문에 시간초과를 피하기 위해 nlogn 방식을 사용(이분탐색)
0부터 k까즤의 인덱스를 시작점을 가진 그룹을 만들어줍니다.
각 그룹에서 가장 긴 LIS를 제외한 나머지 숫자들을 모두 변경해주면 됩니다.


2. 시간복잡도 :
O( logn * n * k )

3. 자료구조/알고리즘 :
배열 / LIS (이분탐색)
 */

public class Q2111 {
    class Solution {
        public int binarySearch(List<Integer> lis, int target) { //index of lowest
            int left = 0, right = lis.size();

            while (left < right) {
                int mid = left + (right - left)/2;

                if (target < lis.get(mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        public int getLength(List<Integer> arr) {
            List<Integer> lis = new ArrayList<>();

            for (int num : arr) {
                int pos = binarySearch(lis, num);

                if (pos == lis.size()) {
                    lis.add(num);
                } else {
                    lis.set(pos, num);
                }
            }
            return lis.size();
        }

        public int kIncreasing(int[] arr, int k) {
            int n = arr.length;
            int ans = 0;
            for (int i=0; i<k; i++) {
                List<Integer> alist = new ArrayList<>();
                for (int j=i; j<n; j+=k) {
                    alist.add(arr[j]);
                }
                ans += alist.size() - getLength(alist);
            }
            return ans;
        }
    }
}
