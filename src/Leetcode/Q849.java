package Leetcode;

/*
1. 아이디어 :
왼쪽, 오른쪽 누적합을 구합니다. 왼쪽 누적합은 i번째 인덱스를 기준으로 왼쪽에 있는 1의 거리, 오른쪽은 반대.
거리를 임의의 수(n)으로 두고, 1을 만나면 0으로 초기화, 0이면 +1을 해줍니다.
인덱스를 돌면서 왼쪽, 오른쪽 누적합을 비교하여 최소값을 구합니다.

2. 시간복잡도 :
O( 2n )

3. 자료구조/알고리즘 :
- / 누적합
 */

public class Q849 {
    class Solution {
        public int maxDistToClosest(int[] seats) {
            int n = seats.length;
            int[] leftPrefix = new int[n];
            int[] rightPrefix = new int[n];

            int currDistanceLeft = n, currDistanceRight = n;
            for (int i=0; i<n; i++) {
                if (seats[i] == 1) {
                    currDistanceLeft = 0;
                    leftPrefix[i] = currDistanceLeft;
                } else {
                    currDistanceLeft++;
                    leftPrefix[i] = currDistanceLeft;
                }

                if (seats[n-i-1] == 1) {
                    currDistanceRight = 0;
                    rightPrefix[n-i-1] = currDistanceRight;
                } else {
                    currDistanceRight++;
                    rightPrefix[n-i-1] = currDistanceRight;
                }
            }

            int ans = 0;
            for (int i=0; i<n; i++) {
                ans = Math.max(ans, Math.min(leftPrefix[i], rightPrefix[i]));
            }
            return ans;
        }
    }
}
