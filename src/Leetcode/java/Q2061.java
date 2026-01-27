package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2061 {
    class Solution {
        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};
        int[][] visited;
        int ans = 1;
        public int numberOfCleanRooms(int[][] room) {
            int n = room.length, m = room[0].length;
            visited = new int[n][m];

            int x = 0, y = 0, dir = 0;
            visited[x][y]++;
            for (int i=0; i<9; i++) {
                while (x + dx[dir] >= 0
                        && y + dy[dir] >= 0
                        && x + dx[dir] <n
                        && y + dy[dir] <m
                        && room[x+dx[dir]][y+dy[dir]] == 0
                ) {
                    x += dx[dir];
                    y += dy[dir];
                    visited[x][y]++;
                    if (visited[x][y]==1) ans++;
                    if (visited[x][y] >= 3) return ans;
                }
                dir = (dir+1)%4;
            }
            return ans;
        }
    }
}
