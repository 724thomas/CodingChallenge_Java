package Leetcode;

/*
1. 아이디어 :
bfs를 사용할 수 있습니다.
모든 격자를 방문하면, 10**6이므로 시간초과가 발생합니다.
장애물을 놓을 수 있는 갯수 200개를 활용하여, source와 target을 감싸고 있는지 확인합니다.

2. 시간복잡도 :
O( 40000 )

3. 자료구조/알고리즘 :
해시셋, deque / bfs
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Q1036 {
    class Solution {
        int n = 1_000_000;
        Set<String> block = new HashSet<>();
        int[][] blocked;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        public int getDist(int row1, int col1, int row2, int col2) {
            return Math.abs(row1 - row2) + Math.abs(col1 - col2);
        }

        public boolean bfs(int row, int col, int row2, int col2) {
            Set<String> visited = new HashSet<>();
            visited.add(row + "-" + col);

            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{row, col, 0});

            while (!deque.isEmpty()) {
                int[] c = deque.pollFirst();
                int x = c[0], y = c[1], d = c[2];
                if (visited.size()>=20000 || (x == row2 && y == col2)) return true;

                for (int i=0; i<4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    String key = nx + "-" + ny;
                    if (nx<0 || ny<0 || nx>=n || ny>=n || visited.contains(key) || block.contains(key)) continue;
                    visited.add(key);
                    deque.add(new int[]{nx, ny, d+1});
                }
            }
            return false;
        }
        public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
            for (int[] b : blocked) block.add(b[0] + "-" + b[1]);

            return bfs(source[0], source[1], target[0], target[1])
                    && bfs(target[0], target[1], source[0], source[1]);
        }
    /*
    dist = 3

    [0,0,0,3,0,0,0]
    [0,0,3,2,3,0,0]
    [0,3,2,1,2,3,0]
    [3,2,1,0,1,2,3]
    [0,3,2,1,2,3,0]
    [0,0,3,2,3,0,0]
    [0,0,0,3,0,0,0]
    */
    }
}
