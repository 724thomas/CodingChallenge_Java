package Leetcode;

/*
1. 아이디어 :
백트래킹으로 모든 경우의 수를 구합니다.
posDiag, negDiag, cols를 사용하여 퀸이 놓일 수 있는 위치를 체크합니다.
posDiag는 상향하는 대각선, negDiag는 하향하는 대각선, cols는 열을 체크합니다.
각 행마다 가능한 열에 퀸을 놓고, 다음 행으로 넘어가서 재귀적으로 진행합니다.

2. 시간복잡도 :
O( n**n )

3. 자료구조/알고리즘 :
Set, List / 백트래킹
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q51 {
    class Solution {
        int n;
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        List<List<String>> ans = new ArrayList<>();

        public void backtrack(int row, List<String> curr) {
            if (row >= n) {
                ans.add(new ArrayList<>(curr));
                return;
            }

            for (int col = 0; col<n; col++) {
                if (cols.contains(col)) continue;
                if (posDiag.contains(row+col)) continue;
                if (negDiag.contains(row-col)) continue;

                StringBuilder sb = new StringBuilder();
                for (int i=0; i<col; i++) sb.append(".");
                sb.append("Q");
                for (int i=col+1; i<n; i++) sb.append(".");

                cols.add(col);
                posDiag.add(row+col);
                negDiag.add(row-col);
                curr.add(sb.toString());

                backtrack(row+1, curr);

                cols.remove(col);
                posDiag.remove(row+col);
                negDiag.remove(row-col);
                curr.remove(curr.size()-1);
            }
        }

        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            backtrack(0, new ArrayList<>());
            return ans;
        }
    }
}
