# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    int[] start;
    int[] lever;
    int[] end;
    int N;
    int M;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};

    public int bfs(String[] maps, int[] st, int[] de){
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        visited[st[0]][st[1]] = true;
        queue.add(new int[]{st[0], st[1], 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], d = curr[2];

            if (x==de[0] && y==de[1]) return d;

            for (int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i], nd = d+1;
                if (nx<0 || nx >= N || ny < 0 || ny >= M) continue;
                if (maps[nx].charAt(ny) == 'X' || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, nd});
            }
        }
        return -1;
    }

    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        for (int i=0; i<N; i++) for (int j=0; j<M; j++) {
            if (maps[i].charAt(j) == 'S') start = new int[]{i, j};
            if (maps[i].charAt(j) == 'L') lever = new int[]{i, j};
            if (maps[i].charAt(j) == 'E') end = new int[]{i, j};
        }

        int toLever = bfs(maps, start, lever);
        int toEnd = bfs(maps, lever, end);
        return (toLever == -1 || toEnd == -1)? -1 : toLever + toEnd;
    }
}
'''



