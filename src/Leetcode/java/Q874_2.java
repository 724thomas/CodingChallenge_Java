package Leetcode.java;

/*
1. 아이디어 :
다음 좌표를 구하는 getNextCord 메서드를 구현.
현재 좌표 (x,y)와 방향 dir, 이동 거리 dist를 받아서 이동할 수 있는 좌표를 구한다.
만약 장애물에 걸리면, 장애물 바로 앞 좌표를 반환한다.
(getNextCord 메서드에서 장애물에 걸리는지 확인하기 위해, 장애물의 좌표를 문자열로 만들어 Set에 저장)

이동 명령을 처리할 때, -1은 오른쪽으로 회전, -2는 왼쪽으로 회전, 양수는 해당 거리만큼 이동.

2. 시간복잡도 :
O( n * m )

3. 자료구조/알고리즘 :
해시셋 / -
 */

import java.util.HashSet;
import java.util.Set;

public class Q874_2 {
    class Solution {
        int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
        int dir = 0;

        Set<String> obs = new HashSet<>();
        int ans = 0;

        public int[] getNextCord(int x, int y, int dir, int dist) {
            for (int i=0; i<dist; i++) {
                x += dx[dir];
                y += dy[dir];
                String key = x + "-" + y;
                if (obs.contains(key)) return new int[]{x-dx[dir], y-dy[dir]};
            }
            return new int[]{x, y};
        }

        public int robotSim(int[] commands, int[][] obstacles) {
            int x = 0, y = 0;
            for (int[] ob : obstacles) obs.add(ob[0] + "-" + ob[1]);

            for (int c : commands) {
                if (c == -1) {
                    dir = (4 + dir + 1) % 4;
                } else if (c == -2) {
                    dir = (4 + dir - 1) % 4;
                } else {
                    int[] nextCord = getNextCord(x, y, dir, c);
                    x = nextCord[0];
                    y = nextCord[1];
                }
                ans = Math.max(ans, x*x + y*y);
            }


            return ans;
        }
    }
}
