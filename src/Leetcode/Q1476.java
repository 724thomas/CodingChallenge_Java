package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q1476 {
    class SubrectangleQueries {
        int[][] grid;
        List<int[]> updates;
        public SubrectangleQueries(int[][] rectangle) {
            grid = rectangle;
            updates = new ArrayList<>();
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            updates.add(new int[]{row1, col1, row2, col2, newValue});
        }

        public int getValue(int row, int col) {
            int gridVal = grid[row][col];
            for (int[] u: updates) {
                int row1 = u[0], col1 = u[1], row2 = u[2], col2 = u[3], val = u[4];
                if (row>=row1 && col>=col1 && row<=row2 && col<=col2) {
                    gridVal = val;
                }
            }
            return gridVal;
        }
    }

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */
}
