package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q666 {
    class Solution {
        int ans = 0;
        Integer[][] matrix;
        int n;
        public void backtrack(int row, int col, int curr) {
            if (matrix[row][col] == null) return;
            curr += matrix[row][col];

            boolean leftNull = (row+1 >= 4 || matrix[row+1][col*2] == null);
            boolean rightNull = (row+1 >= 4 || matrix[row+1][col*2+1] == null);

            if (leftNull && rightNull) {
                ans += curr;
                return;
            }
            backtrack(row+1, col*2, curr);
            backtrack(row+1, col*2+1, curr);
        }

        public int pathSum(int[] nums) {
            n = nums.length;
            matrix = new Integer[4][8];

            for (int num : nums) {
                String rep = String.valueOf(num);
                int depths = Integer.parseInt(rep.charAt(0)+"")-1;
                int pos = Integer.parseInt(rep.charAt(1)+"")-1;
                int val = Integer.parseInt(rep.charAt(2)+"");
                matrix[depths][pos] = val;
            }

            backtrack(0,0,0);
            return ans;
        }
    }
}
