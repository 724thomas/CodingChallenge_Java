# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    -
2. 시간복잡도 :
    O(    )
3. 자료구조 :
    -
import java.util.*;
class Solution {
    int N;
    int ans = 0;

    Set<Integer> colSet = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();

    public void backtrack(int row) {
        if (row == N) {
            ans++;
            return;
        }

        for (int col = 0; col<N; col++) {
            if (colSet.contains(col) || posDiag.contains(row - col) || negDiag.contains(row + col)) continue;
            colSet.add(col);
            posDiag.add(row-col);
            negDiag.add(row+col);
            backtrack(row+1);
            colSet.remove(col);
            posDiag.remove(row-col);
            negDiag.remove(row+col);
        }
    }

    public int solution(int n) {
        N = n;
        backtrack(0);
        return ans;
    }
}
'''



