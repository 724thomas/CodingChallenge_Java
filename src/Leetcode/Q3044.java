package Leetcode;

/*
1. 아이디어 :
각 격자에서 8방향으로 시작하는 모든 숫자 조합을 만들고, 그 중 소수인 숫자의 빈도를 세어 가장 많이 등장한 소수를 찾습니다.

2. 시간복잡도 :
O( n * m * 8 * Math.max(n, m) )

3. 자료구조/알고리즘 :
- / 브루트포스
 */

import java.util.HashMap;
import java.util.Map;

public class Q3044 {
    class Solution {
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        public boolean isPrime(int num) {
            for (int i=2; i<Math.sqrt(num)+1; i++) {
                if (num%i==0) return false;
            }
            return true;
        }
        public int mostFrequentPrime(int[][] mat) {
            int n = mat.length, m = mat[0].length;
            Map<Integer, Integer> counter = new HashMap<>();

            for (int row=0; row<n; row++) for (int col=0; col<m; col++) {
                for (int dir=0; dir<8; dir++) {
                    int total = mat[row][col];
                    int nx = row + dx[dir], ny = col+dy[dir];;
                    while (nx>=0 && ny>=0 && nx<n && ny<m) {
                        total = total * 10 + mat[nx][ny];
                        nx += dx[dir];
                        ny += dy[dir];
                        counter.put(total, counter.getOrDefault(total, 0)+1);
                    }
                }
            }

            int freq = 0;
            int ans = -1;
            for (var entry : counter.entrySet()) {
                int num = entry.getKey(), count = entry.getValue();
                if (num < 10 || !isPrime(num)) continue;
                if (count > freq) {
                    freq = count;
                    ans = num;
                } else if (count==freq) {
                    ans = Math.max(ans, num);
                }
            }
            return ans;
        }
    }
}
