package Leetcode;

/*
1. 아이디어 :
1씩 증가, 감소

2. 시간복잡도 :
O( time )

3. 자료구조/알고리즘 :
- / -
 */

public class Q2582 {
    class Solution {
        public int passThePillow(int n, int time) {
            int curr = 1, dir = -1;
            for (int i=0; i<time; i++) {
                if (curr == 1 || curr == n) dir *=-1;
                curr += dir;
            }
            return curr;
        }
    }
}
