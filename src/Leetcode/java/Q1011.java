package Leetcode.java;

/*
1. 아이디어 :
이분탐색을 통해 minWeight를 구합니다.
minWeight를 기준으로 d days내에 운반이 가능하닞 확인합니다.

2. 시간복잡도 :
O( logn * n)

3. 자료구조/알고리즘 :
- / 이분탐색
 */

public class Q1011 {
    class Solution {
        public boolean check(int[] weights, int days, int minWeight) {
            int curr = 0;
            days--;

            for (int weight : weights) {
                if (weight > minWeight) return false;
                if (curr + weight > minWeight) {
                    days--;
                    curr = 0;
                }
                curr += weight;
            }
            return days>=0;
        }
        public int shipWithinDays(int[] weights, int days) {
            int left = 0, right = 500 * 50000;
            while (left < right) {
                int mid = left + (right-left)/2;
                if (check(weights, days, mid)) {
                    right = mid;
                } else {
                    left = mid+1;
                }
            }
            return left;
        }
    }
}
