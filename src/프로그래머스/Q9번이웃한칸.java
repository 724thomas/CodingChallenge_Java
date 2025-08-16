package 프로그래머스;

/*
1. 아이디어 :
-

2. 시간복잡도 :
O( 4 )

3. 자료구조/알고리즘 :
- / -
 */

public class Q9번이웃한칸 {
    class Solution {
        public int solution(String[][] board, int h, int w) {
            int n = board.length, m = board[0].length;
            int count = 0;
            int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};

            String curr = board[h][w];
            for (int i=0; i<4; i++) {
                int nx = h+dx[i], ny = w+dy[i];
                if (nx<0||ny<0||nx>=n||ny>=m) continue;
                if (board[nx][ny].equals(curr)) count++;
            }
            return count;
        }
    }
}
