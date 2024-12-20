# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    -
2. 시간복잡도 :
    O(    )
3. 자료구조 :
    -
import java.util.*;

class Solution {
    int N, M;
    int[][] visited;
    int areaNum = 0;
    Map<Integer, Integer> area = new HashMap<>();

    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    public void bfs(int row, int col, int[][] land) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, col});
        visited[row][col] = areaNum;
        int size = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny] != 0 || land[nx][ny] == 0) continue;

                visited[nx][ny] = areaNum;
                size++;
                queue.add(new int[]{nx, ny});
            }
        }

        area.put(areaNum, size);
    }

    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        visited = new int[N][M];
        int maxOil = 0;

        for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) {
            if (land[i][j] == 1 && visited[i][j] == 0) {
                areaNum++;
                bfs(i, j, land);
            }
        }

        for (int col = 0; col < M; col++) {
            Set<Integer> uniqueAreas = new HashSet<>();
            for (int row = 0; row < N; row++) {
                if (visited[row][col] != 0) {
                    uniqueAreas.add(visited[row][col]);
                }
            }

            int totalOil = 0;
            for (int areaId : uniqueAreas) {
                totalOil += area.get(areaId);
            }

            maxOil = Math.max(maxOil, totalOil);
        }

        return maxOil;
    }
}

'''



