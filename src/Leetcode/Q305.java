package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q305 {
    class Solution {
        int[] par;
        int[] rank;
        int rows, cols;

        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,-1,1};

        public int getIndex(int x, int y) {
            return x*cols + y;
        }

        public int find(int x) {
            if (x != par[x]) {
                par[x] = find(par[x]);
            }
            return par[x];
        }

        public boolean union(int a, int b) {
            int ra = find(a);
            int rb = find(b);

            if(ra == rb) return false;

            if (rank[ra] > rank[rb]) {
                par[rb] = ra;
            } else if (rank[ra] < rank[rb]) {
                par[ra] = rb;
            } else {
                rank[ra]++;
                par[rb] = ra;
            }
            return true;
        }

        public List<Integer> numIslands2(int m, int n, int[][] positions) {
            rows = m;
            cols = n;
            int size = rows * cols;
            par = new int[size];
            rank = new int[size];

            for (int i=0; i<size; i++) {
                par[i] = i;
                rank[i] = 0;
            }

            int[][] board = new int[rows][cols];
            List<Integer> result = new ArrayList<>();
            int count=0;

            for (int[] pos: positions) {
                int x = pos[0], y = pos[1];

                if (board[x][y] == 1) {
                    result.add(count);
                    continue;
                }

                board[x][y] = 1;
                count++;

                int index = getIndex(x,y);
                for (int d=0; d<4; d++) {
                    int nx = x+dx[d], ny = y+dy[d];

                    if (nx<0||ny<0 || nx>= rows || ny >= cols || board[nx][ny]==0) {
                        continue;
                    }

                    int neighborIndex = getIndex(nx, ny);
                    if (union(index, neighborIndex)) {
                        count--;
                    }
                }
                result.add(count);
            }
            return result;
        }
    }
}
