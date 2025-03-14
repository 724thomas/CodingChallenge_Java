package Leetcode;

/*
1. 아이디어 :
3개씩 확인합니다

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
- / -
 */

public class Q3206 {
    class Solution {
        public int numberOfAlternatingGroups(int[] colors) {
            int ans = 0;
            for (int i=0; i<colors.length; i++) ans += (colors[i] == colors[(i+2) % colors.length] && colors[i] != colors[(i+1) % colors.length]) ? 1: 0;
            return ans;
        }
    }
}
