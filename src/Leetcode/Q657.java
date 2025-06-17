package Leetcode;

/*
1. 아이디어 :
U(Up) : x++
D(Down) : x--
L(Left) : y++
R(Right) : y--
만약 x와 y가 모두 0이라면, 시작점으로 돌아온 것.

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
- / -
 */

public class Q657 {
    class Solution {
        public boolean judgeCircle(String moves) {
            int x = 0, y = 0;
            for (Character m : moves.toCharArray()) {
                if (m == 'U') x++;
                else if (m == 'D') x--;
                else if (m == 'L') y++;
                else if (m == 'R') y--;
            }
            return x == 0 && y == 0;
        }
    }
}
