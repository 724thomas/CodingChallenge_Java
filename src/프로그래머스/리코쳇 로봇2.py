# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    int[] dx = new int[]{1,-1,0,0};
    int[] dy = new int[]{0,0,1,-1};
    int N;
    int M;

    public List<int[]> getCords(String[] board, int x, int y) {
        List<int[]> cords = new ArrayList<>();
        for (int i=0; i<4; i++) {
            int nx = x+dx[i], ny = y+dy[i];
            while (nx>=0 && ny>=0 && nx<N && ny < M && board[nx].charAt(ny) != 'D') {
                nx += dx[i];
                ny += dy[i];
            }
            cords.add(new int[]{nx-dx[i], ny-dy[i]});
        }
        return cords;

    }
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        int[] start = new int[]{-1,-1}, end = new int[]{-1,-1};
        for (int i=0; i<N; i++) for (int j=0; j<M; j++) {
            if (board[i].charAt(j) == 'R') {
                start = new int[]{i, j};
            }
            if (board[i].charAt(j) == 'G') {
                end = new int[]{i, j};
            }
        }

        boolean[][] visited = new boolean[N][M];
        visited[start[0]][start[1]] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start[0], start[1], 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], d = curr[2];

            if (x==end[0] && y==end[1]) return d;

            for (int[] nextCord : getCords(board, x, y)) {
                int nx = nextCord[0], ny = nextCord[1], nd = d+1;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.add(new int[]{nx,ny,nd});
            }
        }
        return -1;
    }
}
'''



