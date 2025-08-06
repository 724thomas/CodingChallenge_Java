package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q74 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            int left = 0, right = m * n - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int midVal = matrix[mid / n][mid % n];

                if (midVal == target) return true;
                if (midVal < target) left = mid + 1;
                else right = mid - 1;
            }

            return false;
        }

    }
}
