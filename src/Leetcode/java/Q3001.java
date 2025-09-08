package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3001 {
    class Solution {
        public boolean bfs(int ax, int ay, int bx, int by, int e, int f, int[] dx, int[] dy) {
            for (int i=0; i<4; i++) {
                int nx = ax, ny = ay;
                while (true) {
                    nx += dx[i];
                    ny += dy[i];
                    if (nx<0||ny<0||nx>=8||ny>=8) break;
                    if (nx == bx && ny == by) break;
                    if (nx == e && ny == f) return true;
                }
            }
            return false;
        }
        public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
            return bfs(a-1, b-1, c-1, d-1, e-1, f-1, new int[]{1,-1,0,0}, new int[]{0,0,-1,1})
                || bfs(c-1, d-1, a-1, b-1, e-1, f-1, new int[]{1,1,-1,-1}, new int[]{1,-1,1,-1}) ? 1 : 2;
        }
    }
}
