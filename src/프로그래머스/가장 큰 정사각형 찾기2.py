# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution{
    public int solution(int [][]board) {
        /*
        0 1 1 1
        1 1 2 2
        1 2 2 3
        0 0 1 0
        */
        int ans = 0;
        int N = board.length, M = board[0].length;
        for (int i=0; i<N; i++) for (int j=0; j<M; j++) {
            ans = Math.max(ans, board[i][j]);
            if (i == 0 || j == 0) continue;
            if (board[i][j] == 0 || board[i-1][j-1] == 0 || board[i][j-1] == 0 || board[i-1][j]==0) continue;
            int minVal = Math.min(board[i-1][j-1], Math.min(board[i][j-1], board[i-1][j])) +1;
            board[i][j] = minVal;
            ans = Math.max(ans, minVal);
        }
        return ans*ans;
    }
}
'''



