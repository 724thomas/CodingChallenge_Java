package 프로그래머스;

/*
1. 아이디어 :
dp를 통해 최소 전력소비량을 저장.
-10도부터 40도까지 OFFSET 10을 더해서 0~50까지의 인덱스로 사용.
에어컨 끈 경우, 온도에 따라 -1, 0, +1도 변화.
에어컨 킨 경우, 온도 변화 없이 b 전력소비량, -1도 변화시 a 전력소비량, +1도 변화시 a 전력소비량.
1. 끈 경우, 사람이 없거나, 있다면 범위 안에 있을떄 계산
2. 킨 경우 유지
3. 킨 경우 -1도
4. 킨 경우 +1도
위 4가지 상황 계산


2. 시간복잡도 :
O( n * 51)

3. 자료구조/알고리즘 :
2차원 배열 / dp
 */

import java.util.Arrays;

public class Q에어컨 {
    class Solution {
        public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        /*
        실외온도를 나타내는 정수 temperature,
        쾌적한 실내온도의 범위를 나타내는 정수 t1, t2,
        에어컨의 소비전력을 나타내는 정수 a, b
        승객이 탑승 중인 시간을 나타내는 1차원 정수 배열 onboard
        dp[n][50] offset = 10;
        */

            int n = onboard.length;
            int[][] dp = new int[n+1][51];
            int OFFSET = 10;
            for (int i=0; i<n+1; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            dp[0][temperature + OFFSET] = 0;

            for (int i=0; i<n; i++) {
                for (int temp = -10; temp<=40; temp++) {
                    int tempIdx = temp + OFFSET;
                    int currCost = dp[i][tempIdx];
                    if (currCost == Integer.MAX_VALUE) continue;

                    boolean person = onboard[i] == 1;

                    // 끈 경우
                    int diff = (temp < temperature) ? 1 : (temp == temperature) ? 0 : -1;
                    int offTemperature = temp + diff;
                    if (offTemperature >= -10 && offTemperature <= 40) {
                        if (!person || (t1 <= offTemperature && offTemperature <= t2)) {
                            dp[i+1][offTemperature + OFFSET] = Math.min(currCost, dp[i+1][offTemperature + OFFSET]);
                        }
                    }

                    // 킨 경우 b
                    if (!person || (t1<=temp && temp <= t2)) {
                        dp[i+1][tempIdx] = Math.min(dp[i+1][tempIdx], currCost + b);
                    }

                    int nTemp;
                    // 킨 경우 a -1도
                    if (temp - 1 >= -10) {
                        nTemp = temp-1;
                        if (!person || (t1 <= nTemp && nTemp <= t2)) {
                            dp[i+1][nTemp + OFFSET] = Math.min(dp[i+1][nTemp + OFFSET], currCost + a);
                        }
                    }

                    // 킨 경우 a +1도
                    if (temp + 1 <= 40) {
                        nTemp = temp + 1;
                        if (!person || (t1 <= nTemp && nTemp <= t2)) {
                            dp[i+1][nTemp + OFFSET] = Math.min(dp[i+1][nTemp+OFFSET], currCost + a);
                        }
                    }
                }
            }

            // for (var d : dp) System.out.println(Arrays.toString(d));

            int ans = Integer.MAX_VALUE;
            for (int i=0; i<50; i++) {
                ans = Math.min(ans, dp[n][i]);
            }
            return ans;
        }
    }
}
