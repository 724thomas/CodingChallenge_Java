# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    dp[row][col][0] : 오른쪽 방향 경우의 수
    dp[row][col][1] : 아래쪽 방향 경우의 수

    cityMap[row][col] == 1인 경우: 이동할 수 없고 그대로 (0,0) 이다.
    cityMap[row][col] == 2인 경우: 진행 방향으로만 갈 수 있기떄문에 dp[row][col-1]의 오른쪽 방향 경우의 수를 그대로 가져오고, dp[row-1][col]의 아래쪽 방향 경우의 수를 그대로 가져온다.
    cityMap[row][col] == 0인 경우: 오른쪽 방향 경우의 수는 dp[row][col-1]의 오른쪽 방향 경우의 수와 dp[row-1][col]의 아래쪽 방향 경우의 수를 더하고, 아래쪽 방향 경우의 수는 오른쪽 방향 경우의 수와 아래쪽 방향 경우의 수를 더한다.
2. 시간복잡도 :
    O(n * m)
3. 자료구조 :
    3차배열

import java.util.*;
class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int rows = m, cols = n;
        int[][][] dp = new int[rows][cols][2]; // right, down
        dp[0][0] = new int[]{1,1};

        for (int row=1; row<rows; row++) {
            if (cityMap[row][0] == 1) break;
            dp[row][0][1] = 1;
            dp[row][0][0] = cityMap[row][0] == 2 ? 0: 1;
        }
        for (int col=1; col<cols; col++) {
            if (cityMap[0][col] == 1) break;
            dp[0][col][0] = 1;
            dp[0][col][1] = cityMap[0][col] == 2 ? 0: 1;
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (cityMap[row][col] == 1) continue;
                if (cityMap[row][col] == 2) {
                    dp[row][col][0] = dp[row][col-1][0] % MOD;
                    dp[row][col][1] = dp[row-1][col][1] % MOD;
                } else {
                    dp[row][col][0] = (dp[row][col-1][0] + dp[row-1][col][1]) % MOD;
                    dp[row][col][1] = (dp[row][col-1][0] + dp[row-1][col][1]) % MOD;
                }
            }
        }
        return (dp[rows-1][cols-1][0]) % MOD;
    }
}

'''


def solution(m, n, cityMap):
    MOD = 20170805
    rows, cols = m, n
    dp = [[[0, 0] for _ in range(cols)] for _ in range(rows)]
    dp[0][0] = [1, 1]

    for row in range(1, rows):
        if cityMap[row][0] == 1: break
        dp[row][0][1] = 1
        dp[row][0][0] = 0 if cityMap[row][0] == 2 else 1

    for col in range(1, cols):
        if cityMap[0][col] == 1: break
        dp[0][col][0] = 1
        dp[0][col][1] = 0 if cityMap[0][col] == 2 else 1

    for row in range(1, rows):
        for col in range(1, cols):
            if cityMap[row][col] == 1: continue
            if cityMap[row][col] == 2:
                dp[row][col][0] = dp[row][col - 1][0] % MOD
                dp[row][col][1] = dp[row - 1][col][1] % MOD
            else:
                dp[row][col][0] = (dp[row][col - 1][0] + dp[row - 1][col][1]) % MOD
                dp[row][col][1] = (dp[row][col - 1][0] + dp[row - 1][col][1]) % MOD
    return dp[rows - 1][cols - 1][0]
