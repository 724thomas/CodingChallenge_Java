# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {

    int[] dx = new int[]{0,0,1,-1};
    int[] dy = new int[]{1,-1,0,0};

    public int bfs(int[][] board, int sx, int sy, int ex, int ey) {
        Set<String> visited = new HashSet<>();
        Deque<int[]> deque = new ArrayDeque<>(); //x, y, count
        deque.addLast(new int[]{sx, sy, 0});

        while (!deque.isEmpty()) {
            int[] cords = deque.pollFirst();
            // System.out.println(cords[0] + " " + cords[1] + " " + cords[2]);
            if (cords[0] == ex && cords[1] == ey) return cords[2];
            for (int i=0; i<4; i++) {
                int nx = cords[0] + dx[i], ny = cords[1] + dy[i];
                String sCords = nx + "-" + ny;
                if (board[nx][ny] != 1 || visited.contains(sCords)) continue;
                visited.add(sCords);
                deque.addLast(new int[]{nx, ny, cords[2]+1});
            }
        }

        return -1;
    }

    public int solution(int[][] rectangles, int characterX, int characterY, int itemX, int itemY) {
        int n = 102, m = 102;
        int[][] board = new int[n][m];
        for (int[] b : board) Arrays.fill(b, 2);

        for (int[] cord : rectangles) {
            for (int row = cord[1]*2; row<=cord[3] * 2; row++) {
                for (int col = cord[0]*2; col<=cord[2] * 2; col++) {
                    if (board[row][col] == 0) continue;
                    if (row == cord[1]*2 || row == cord[3]*2 || col == cord[0]*2 || col == cord[2]*2) {
                        board[row][col] = 1;
                    } else {
                        board[row][col] = 0;
                    }
                }
            }
        }
        // for (int i=board.length-1; i>-1; i--) System.out.println(Arrays.toString(board[i]));

        return bfs(board, characterY*2, characterX*2, itemY*2, itemX*2) / 2;
    }
}
'''



