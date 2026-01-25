package Leetcode.java;

/*
1. 아이디어 :
캐싱으로 TLE 회피

2. 시간복잡도 :
O( n * m )

3. 자료구조/알고리즘 :
-
 */

public class Q2013 {
    class DetectSquares {
        int[][] cnt;

        public DetectSquares() {
            cnt = new int[1001][1001];
        }

        public void add(int[] point) {
            cnt[point[0]][point[1]]++;
        }

        public int count(int[] point) {
            int x = point[0], y = point[1];
            int ans = 0;

            for (int ny = 0; ny <= 1000; ny++) {
                if (ny == y) continue;
                int c = cnt[x][ny];
                if (c == 0) continue;

                int d = ny - y;

                int xr = x + d;
                if (0 <= xr && xr <= 1000) {
                    ans += c * cnt[xr][y] * cnt[xr][ny];
                }

                int xl = x - d;
                if (0 <= xl && xl <= 1000) {
                    ans += c * cnt[xl][y] * cnt[xl][ny];
                }
            }

            return ans;
        }
    }

}
