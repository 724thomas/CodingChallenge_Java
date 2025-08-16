package 프로그래머스;

/*
1. 아이디어 :
bfs
- 메모리 효율성을 위해 land에 idx를 저장

2. 시간복잡도 :
O( n * m + n * m)

3. 자료구조/알고리즘 :
해시맵 / bfs
 */

import java.util.*;

public class Q석유시추 {
    class Solution {
        Map<Integer, Integer> size = new HashMap<>();
        int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
        int[][] land;
        int n,m;

        private int bfs(int row, int col, int idx) {
            int count = 1;

            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{row, col});
            land[row][col] = idx;

            while (!deque.isEmpty()) {
                int[] curr = deque.poll();
                int x = curr[0], y = curr[1];

                for (int i=0; i<4; i++) {
                    int nx = x +dx[i], ny = y +dy[i];
                    if (nx<0||ny<0||nx>=n||ny>=m) continue;
                    if (land[nx][ny]==1) {
                        count++;
                        land[nx][ny] = idx;
                        deque.add(new int[]{nx,ny});
                    }
                }
            }

            return count;
        }

        public int solution(int[][] land) {
            this.land = land;
            n = land.length;
            m = land[0].length;

            int idx = 1;
            for (int i=0; i<n; i++) for (int j=0; j<m; j++) {
                if (land[i][j] == 1) {
                    idx++;
                    size.put(idx, bfs(i, j, idx));
                }
            }

            int ans = 0;
            for (int col = 0; col<m; col++) {
                int total = 0;
                Set<Integer> visited = new HashSet<>();
                for (int row=0; row<n; row++) {
                    int val = land[row][col];
                    if (val != 0 && !visited.contains(val)) {
                        visited.add(val);
                        total += size.getOrDefault(val, 0);
                    }
                }
                ans = Math.max(ans, total);
            }
            return ans;
        }
    }
}
