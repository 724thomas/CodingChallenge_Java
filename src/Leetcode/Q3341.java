package Leetcode;

/*
1. 아이디어 :
다익스트라로 풀 수 있습니다.
우선순위큐에 방문할 수 있는 좌표와 그 좌표에 도달했을때의 시간을 저장합니다.
시간순으로 정렬되고, 시간이 가장 빠른것부터 하나씩 꺼내면서 방문할 수 있는 좌표를 찾아서 우선순위큐에 넣습니다.
이 과정을 반복하면서 마지막 좌표에 도달했을때의 시간을 반환합니다.

2. 시간복잡도 :
O( n * m * log(n*m) )

3. 자료구조/알고리즘 :
우선순위큐 / 다익스트라
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q3341 {
    class Solution {
        int n, m;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int[][] moveTime;
        boolean[][] visited;


        public List<int[]> getNextRooms(int x, int y, int time) {
            List<int[]> candids = new ArrayList<>();

            for (int i=0; i<4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx<0 || ny<0 || nx >= n || ny >= m || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                int ntime = Math.max(time+1, moveTime[nx][ny]+1);
                candids.add(new int[]{ntime, nx, ny});
            }
            return candids;
        }
        public int minTimeToReach(int[][] moveTime) {
            this.n = moveTime.length;
            this.m = moveTime[0].length;
            this.moveTime = moveTime;
            visited = new boolean[n][m];

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0] - b[0]); //moveTIme, row, col
            for (int[] candid : getNextRooms(0,0,0)) pq.add(candid);

            while (!pq.isEmpty()) {
                int[] c = pq.poll();
                int time = c[0], row = c[1], col = c[2];
                if (row == n-1 && col == m-1) return time;
                for (int[] candid : getNextRooms(row,col,time)) pq.add(candid);
            }
            return -1;
        }
    }
}
