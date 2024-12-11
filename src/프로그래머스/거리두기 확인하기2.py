# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    int P;
    int N = 5;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};

    public boolean check(String[] place, int row, int col) {
        boolean[][] visited = new boolean[5][5];
        visited[row][col] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row,col,0});

        while (!queue.isEmpty()) {
            int[] c = queue.poll();
            int x = c[0], y = c[1], d = c[2];

            for (int i=0; i<4; i++) {
                int nx = x + dx[i], ny = y + dy[i], nd = d+1;
                if (nx<0 || ny <0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny] || place[nx].charAt(ny) == 'X' || nd > 2) continue;
                if (place[nx].charAt(ny) == 'P') return false;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, nd});
            }
        }
        return true;
    }

    public int checkPlace(String[] place) {
        for (int i=0; i<N; i++) for (int j=0; j<N; j++) {
            if (place[i].charAt(j) == 'P') {
                if (!check(place, i, j)) return 0;
            }
        }
        return 1;
    }

    public int[] solution(String[][] places) {
        P = places.length;
        int[] ans = new int[P];
        for (int i=0; i<P; i++) ans[i] = checkPlace(places[i]);
        return ans;
    }
}
'''



