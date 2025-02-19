package Leetcode;

/*
1. 아이디어 :
2중 포문을 돌면서 1인 지점을 확인하면
현재 grid에 있는 섬들의 사이즈를 구하고, 각 섬마다 고유의 번호를 매기고 맵에 저장합니다.
2중 포문을 돌면서 0인 경우, 상하좌우 섬 번호를 확인하고 맵에서 가져옵니다 (중복X)

2. 시간복잡도 :
O( (n*n*4) * 2)

3. 자료구조/알고리즘 :
배열 / bfs
 */

import java.util.*;

public class Q827 {
    class Solution {
        int n;
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        int[][] grid;
        Map<Integer, Integer> islandSize = new HashMap<>();
        int ans = 0;

        public void bfs(int row, int col) {
            int islandNum = islandSize.size() + 2;
            int count = 1;
            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{row, col});
            grid[row][col] = islandNum;

            while (!deque.isEmpty()) {
                int[] curr = deque.pollFirst();
                int x = curr[0], y = curr[1];

                for (int i=0; i<4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx<0 || nx>=n || ny<0 || ny>=n || grid[nx][ny] != 1) continue;
                    grid[nx][ny] = islandNum;
                    count++;
                    deque.add(new int[]{nx, ny});
                }
            }
            islandSize.put(islandNum, count);
            ans = Math.max(ans, count);
        }

        public int largestIsland(int[][] grid) {
            n = grid.length;
            this.grid = grid;

            for (int i=0; i<n; i++) for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) bfs(i, j);
            }

            Set<Integer> visited = new HashSet<>();
            for (int x=0; x<n; x++) for (int y=0; y<n; y++) {
                if (grid[x][y] == 0) {
                    int curr = 1;
                    visited.clear();
                    for (int d = 0; d<4; d++) {
                        int nx = x + dx[d], ny = y + dy[d];
                        if (nx<0 || nx>=n || ny<0 || ny>=n || visited.contains(grid[nx][ny])) continue;
                        curr += islandSize.getOrDefault(grid[nx][ny], 0);
                        visited.add(grid[nx][ny]);
                    }
                    ans = Math.max(ans, curr);
                }
            }
            return ans;
        }
    }
}
