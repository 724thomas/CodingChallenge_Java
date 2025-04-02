package Leetcode;

/*
1. 아이디어 :
col 길이가 짝수일때, 홀수 일때 나눠서 계산합니다.
각 row마다, 2칸씩 이동하면서 값을 ans에 추가합니다.

2. 시간복잡도 :
O( n * m )

3. 자료구조/알고리즘 :
- / 브루트포스
 */

import java.util.ArrayList;
import java.util.List;

public class Q3417 {
    class Solution {
        public List<Integer> zigzagTraversal(int[][] grid) {
            int n = grid.length, m = grid[0].length;
            List<Integer> ans = new ArrayList<>();
            boolean toRight = true, isOdd = m%2==1;

            for (int i=0; i<n; i++) {
                if (toRight) {
                    for (int j=0; j<m; j+=2) {
                        ans.add(grid[i][j]);
                    }
                } else {
                    if (!isOdd) {
                        for (int j=m-1; j>=0; j-=2) {
                            ans.add(grid[i][j]);
                        }
                    } else {
                        for (int j=m-2; j>=0; j-=2) {
                            ans.add(grid[i][j]);
                        }
                    }

                }
                toRight = !toRight;
            }

            return ans;
        }
    }
}
