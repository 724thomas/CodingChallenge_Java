# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    int[] dx = new int[]{1,0,-1,0};
    int[] dy = new int[]{0,-1,0,1};
    public int solution(int[][] board) {
        int n = board.length, m = board[0].length;
        int[][][] dp = new int[n][m][4]; //row, col, dir
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++) {
                for (int k=0; k<4; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[0] - b[0]); // cost
        for (int i=0; i<4; i++) {
            queue.add(new int[]{0,0,0,i}); // cost, row, col, dir
            dp[0][0][i] = -1;
        }
        // 0 south, 1 west, 2 north, 3 east

        while (!queue.isEmpty()){
            var curr = queue.poll();
            int cost = curr[0], x = curr[1], y = curr[2], d = curr[3];

            for (int i=0; i<4; i++){
                if ((d + 2)%4 == i) continue;
                int nx = x + dx[i], ny = y + dy[i];
                int newDir = i;
                int newCost = i == d? cost+100 : cost+600;
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || dp[nx][ny][newDir] < newCost || board[nx][ny] == 1) continue;
                dp[nx][ny][newDir] = newCost;
                queue.offer(new int[]{newCost, nx, ny, newDir});
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i=0; i<4; i++) ans = Math.min(ans, dp[n-1][m-1][i]);
        return ans;
    }
}

'''


import heapq
def solution(board):
    dir = [[1,0],[0,-1],[-1,0],[0,1]]
    n, m = len(board), len(board[0])
    dp = [[[float('inf')] * 4 for _ in range(m)] for _ in range(n)]
    min_heap = []
    for i in range(4):
        heapq.heappush(min_heap, (0,0,0,i))

    while min_heap:
        cost, x, y, d = heapq.heappop(min_heap)

        for i in range(4):
            if (d+2)%4 == i: continue
            nx, ny = x + dir[i][0], y + dir[i][1]
            new_cost = cost+100 if i == d else cost+600
            if (nx<0 or nx>=n or ny<0 or ny>=m or dp[nx][ny][i] < new_cost or board[nx][ny] == 1): continue
            dp[nx][ny][i] = new_cost;
            heapq.heappush(min_heap, (new_cost, nx, ny, i))

    return min(dp[n-1][m-1])