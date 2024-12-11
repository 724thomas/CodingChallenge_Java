# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;

class Solution {
    int[][] grid;

    public int rotate(int x1, int y1, int x2, int y2) {
        int temp = grid[x1][y1];
        int min = temp;

        // 좌측 col 이동
        for (int i = x1; i < x2; i++) {
            grid[i][y1] = grid[i + 1][y1];
            min = Math.min(min, grid[i][y1]);
        }

        // 하단 row 이동
        for (int i = y1; i < y2; i++) {
            grid[x2][i] = grid[x2][i + 1];
            min = Math.min(min, grid[x2][i]);
        }

        // 우측 col 이동
        for (int i = x2; i > x1; i--) {
            grid[i][y2] = grid[i - 1][y2];
            min = Math.min(min, grid[i][y2]);
        }

        // 상단 row 이동
        for (int i = y2; i > y1; i--) {
            grid[x1][i] = grid[x1][i - 1];
            min = Math.min(min, grid[x1][i]);
        }

        grid[x1][y1 + 1] = temp;
        return min;
    }

    public int[] solution(int rows, int cols, int[][] queries) {
        grid = new int[rows][cols];

        for (int i = 0; i < rows; i++) for (int j = 0; j < cols; j++) grid[i][j] = i * cols + j + 1;

        List<Integer> results = new ArrayList<>();

        for (int[] query : queries) {
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;

            int min = rotate(x1, y1, x2, y2);
            results.add(min);
        }

        return results.stream().mapToInt(i -> i).toArray();
    }
}
'''



