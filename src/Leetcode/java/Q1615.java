package Leetcode.java;

/*
1. 아이디어 :
노드의 크기와 연결 여부를 저장한다.

2. 시간복잡도 :
O( m + n^2 )  // m: 도로의 개수, n: 도시의 개수

3. 자료구조/알고리즘 :
2차원 배열 / 브루트 포스
 */

public class Q1615 {
    class Solution {
        boolean[][] connected;
        int[] sizes;

        public int count(int a, int b) {
            boolean direct = connected[a][b];
            int total = sizes[a] + sizes[b];
            return direct ? total-1 : total;
        }

        public int maximalNetworkRank(int n, int[][] roads) {
            sizes = new int[n];
            connected = new boolean[n][n];
            for (int[] r : roads) {
                int u = r[0], v = r[1];
                connected[u][v] = true;
                connected[v][u] = true;
                sizes[u]++;
                sizes[v]++;
            }

            int ans = 0;
            for (int i=0; i<n; i++) for (int j=i+1; j<n; j++) {
                ans = Math.max(ans, count(i, j));
            }
            return ans;
        }
    }
}
