package Leetcode;

/*
1. 아이디어 :
n과 m은 <=10^5이므로, O(n*m)으로 풀 수 없습니다.
각 row와 col에 대해 가장 왼쪽/오른쪽, 위쪽/아래쪽에 있는 빌딩을 저장합니다.
각 빌딩을 순회하면서 해당 빌딩이 row와 col의 가장 왼쪽/오른쪽, 위쪽/아래쪽에 있는 빌딩 사이에 있는지 확인합니다.

2. 시간복잡도 :
O( m )

3. 자료구조/알고리즘 :
2차원 배열 / 부르트 포스
 */

public class Q3531 {
    class Solution {
        public int countCoveredBuildings(int n, int[][] buildings) {
            int ans = 0;

            int[][] rows = new int[n][2]; // left, right
            // rows[x][0]: x번째 row의 가장 왼쪽에 있는 빌딩의 col
            // rows[x][1]: x번째 row의 가장 오른쪽에 있는 빌딩의 col
            int[][] cols = new int[n][2]; // up, down
            // cols[y][0]: y번째 col의 가장 위쪽에 있는 빌딩의 row
            // cols[y][1]: y번째 col의 가장 아래쪽에 있는 빌딩의 row
            for (int i=0; i<n; i++) {
                rows[i][0] = Integer.MAX_VALUE;
                cols[i][0] = Integer.MAX_VALUE;
            }

            for (int[] b : buildings) {
                int row = b[0]-1, col = b[1]-1;
                rows[row][0] = Math.min(rows[row][0], col);
                rows[row][1] = Math.max(rows[row][1], col);
                cols[col][0] = Math.min(cols[col][0], row);
                cols[col][1] = Math.max(cols[col][1], row);
            }

            for (int[] b : buildings) {
                int row = b[0]-1, col = b[1]-1;
                if (rows[row][0] < col && col < rows[row][1] && cols[col][0] < row && row < cols[col][1]) {
                    ans++;
                }
            }
            return ans;

        }
    }
}
