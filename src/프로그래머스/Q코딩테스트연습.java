package 프로그래머스;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q코딩테스트연습 {
    class Solution {
        public int[] solution(String[] wallpaper) {
            int n = wallpaper.length, m = wallpaper[0].length();
            int sx = Integer.MAX_VALUE;
            int sy = Integer.MAX_VALUE;
            int ex = Integer.MIN_VALUE;
            int ey = Integer.MIN_VALUE;

            for (int i=0; i<n; i++) for (int j=0; j<m; j++) {
                if (wallpaper[i].charAt(j) != '#') continue;
                sx = Math.min(sx, j);
                sy = Math.min(sy, i);
                ex = Math.max(ex, j+1);
                ey = Math.max(ey, i+1);
            }
            return new int[]{sy, sx, ey, ex};
        }
    }
}
