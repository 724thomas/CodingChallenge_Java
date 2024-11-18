# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    왼쪽 발은 항상 왼쪽 또는 위에 위치
    회전 가능한 좌표, 이동 가능한 좌표를 구해서 bfs
2. 시간복잡도 :
    O(n*n)
3. 자료구조 :
    bfs

import java.util.*;

class Solution {
    int N;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public ArrayList<int[]> rotate_cords(int[][] board, int[] l, int[] r, int shape) {
        ArrayList<int[]> candids = new ArrayList<>();

        if (shape == 0) { // 가로
            if (l[0] + 1 < N && board[l[0] + 1][l[1]] == 0 && board[r[0] + 1][r[1]] == 0) {
                candids.add(new int[]{l[0], l[1], l[0] + 1, l[1]});
                candids.add(new int[]{r[0], r[1], r[0] + 1, r[1]});
            }
            if (l[0] - 1 >= 0 && board[l[0] - 1][l[1]] == 0 && board[r[0] - 1][r[1]] == 0) {
                candids.add(new int[]{l[0], l[1], l[0] - 1, l[1]});
                candids.add(new int[]{r[0]-1, r[1], r[0], r[1]});
            }
        } else { // 세로
            if (l[1] + 1 < N && board[l[0]][l[1] + 1] == 0 && board[r[0]][r[1] + 1] == 0) {
                candids.add(new int[]{l[0], l[1], l[0], l[1] + 1});
                candids.add(new int[]{r[0], r[1], r[0], r[1] + 1});
            }
            if (l[1] - 1 >= 0 && board[l[0]][l[1] - 1] == 0 && board[r[0]][r[1] - 1] == 0) {
                candids.add(new int[]{l[0], l[1], l[0], l[1] - 1});
                candids.add(new int[]{r[0], r[1]-1, r[0], r[1]});
            }
        }
        return candids;
    }

    public ArrayList<int[]> move_cords(int[][] board, int[] left, int[] right, int shape) {
        ArrayList<int[]> candids = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int lx = left[0] + dx[i], ly = left[1] + dy[i];
            int rx = right[0] + dx[i], ry = right[1] + dy[i];
            if (lx >= 0 && ly >= 0 && rx >= 0 && ry >= 0 && lx < N && ly < N && rx < N && ry < N &&
                board[lx][ly] == 0 && board[rx][ry] == 0) {
                candids.add(new int[]{lx, ly, rx, ry});
            }
        }
        return candids;
    }

    public int solution(int[][] board) {
        N = board.length;

        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new int[]{0, 0, 0, 1, 0}); // lx, ly, rx, ry, 시간
        visited.add("0,0,0,1");

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int[] left = new int[]{curr[0], curr[1]};
            int[] right = new int[]{curr[2], curr[3]};
            int time = curr[4];

            if ((left[0] == N - 1 && left[1] == N - 1) || (right[0] == N - 1 && right[1] == N - 1)) {
                return time;
            }

            for (int[] c : move_cords(board, left, right, left[0] == right[0] ? 0 : 1)) {
                String key = c[0] + "," + c[1] + "," + c[2] + "," + c[3];
                if (visited.contains(key)) continue;
                visited.add(key);
                queue.offer(new int[]{c[0], c[1], c[2], c[3], time + 1});
            }

            for (int[] c : rotate_cords(board, left, right, left[0] == right[0] ? 0 : 1)) {
                String key = c[0] + "," + c[1] + "," + c[2] + "," + c[3];
                if (visited.contains(key)) continue;
                visited.add(key);
                queue.offer(new int[]{c[0], c[1], c[2], c[3], time + 1});
            }
        }

        return -1;
    }
}

'''



