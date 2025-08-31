package 프로그래머스;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;

public class Q인사고과 {
    public int solution(int[][] scores) {
        int n = scores.length;
        int[] base = scores[0];
        int baseSum = base[0] + base[1];
        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0]-a[0];
        });

        // for (var a : scores) System.out.print(Arrays.toString(a));

        int lastMax = 0;
        int ans = 1;
        for (int[] score : scores) {
            if (base[0] < score[0] && base[1] < score[1]) return -1;
            if (lastMax <= score[1]) {
                if (baseSum < score[0] + score[1]) ans++;
            }
            lastMax = Math.max(lastMax, score[1]);
        }

        return ans;
    }
}
