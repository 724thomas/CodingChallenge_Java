package Leetcode.java;

/*
1. 아이디어 :
구현 문제.
row, col을 시작으로, 대각선으로 내려가면서 nums를 저장.
nums를 정렬 후, 다시 대각선으로 내려가면서 넣어줌.

2. 시간복잡도 :
O( n*n )

3. 자료구조/알고리즘 :
- / -
 */

import java.util.ArrayList;
import java.util.Collections;

public class Q3446 {
    class Solution {
        int[][] grid;
        int n;
        public void sortDiag(int x, int y) {
            ArrayList<Integer> nums = new ArrayList<>();
            nums.add(grid[x][y]);
            int nx = x;
            int ny = y;
            for (int i=0; i<n; i++) {
                if (++nx>=n || ++ny>=n) break;
                nums.add(grid[nx][ny]);
            }

            Collections.sort(nums, (x>=y)? Collections.reverseOrder() : null);

            grid[x][y] = nums.get(0);
            nx = x;
            ny = y;
            for (int i=0; i<n; i++) {
                if (++nx>=n || ++ny>=n) break;
                grid[nx][ny] = nums.get(i+1);
            }
        }

        public int[][] sortMatrix(int[][] grid) {
            this.grid = grid;
            n = grid.length;

            for (int i=0; i<n; i++) {
                sortDiag(i,0);
                sortDiag(0,i);
            }

            return grid;
        }
    }
}
