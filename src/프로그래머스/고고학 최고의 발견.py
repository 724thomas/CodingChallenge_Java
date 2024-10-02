'''
1. 아이디어 :
    백트래킹
2. 시간복잡도 :
    O(4*m + n*m)
3. 자료구조 :
    2차원 배열

import java.util.*;
class Solution {
    int[] dx = new int[]{0,-1,1,0,0};
    int[] dy = new int[]{0,0,0,1,-1};
    int ans = Integer.MAX_VALUE;
    int n;

    public void rotate_one(int[][] clockHands, int row, int col, int times){
        if (row>=0 && row < n && col >=0 && col<n){
            clockHands[row][col] = (clockHands[row][col] + times) % 4;
        }
    }

    public void rotate(int[][] clockHands, int row, int col, int times){
        for (int i=0; i<5; i++) {
            rotate_one(clockHands, row + dx[i], col + dy[i], times);
        }
    }

    public boolean check(int[][] clockHands){
        for (int col=0; col<n; col++) {
            if (clockHands[n-1][col] !=0) return false;
        }
        return true;
    }

    public int fill(int[][] clockHands, int counts) {
        for (int row = 1; row < n; row++) {
            for (int col = 0; col<n; col++) {
                if (clockHands[row-1][col] == 0) continue;
                int rotates = 4 - clockHands[row-1][col];
                rotate(clockHands, row, col, rotates);
                counts += rotates;
            }
        }
        return counts;
    }

    public int[][] deepcopy(int[][] clockHands){
        int[][] temp_clock = new int[n][n];
        for (int row = 0; row < n; row++) temp_clock[row] = Arrays.copyOf(clockHands[row],n);
        return temp_clock;
    }

    public void backtrack(int[][] clockHands, int col, int counts) {
        if (col == n) {
            int[][] temp_clock = deepcopy(clockHands);
            counts = fill(temp_clock, counts);
            if (check(temp_clock)) ans = Math.min(ans, counts);
            return;
        }

        for (int rotates = 0; rotates < 4; rotates ++) {
            rotate(clockHands, 0, col, rotates);
            backtrack(clockHands, col+1, counts + rotates);
            rotate(clockHands, 0, col, 4-rotates);
        }
    }

    public int solution(int[][] clockHands) {
        n = clockHands.length;
        backtrack(clockHands, 0, 0);
        return ans;
    }
}

'''


