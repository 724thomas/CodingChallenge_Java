package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q499 {

    class Solution {
        int[] dx = {1, 0, 0, -1}; // 아래, 왼쪽, 오른쪽, 위
        int[] dy = {0, -1, 1, 0};
        char[] dirs = {'d', 'l', 'r', 'u'};
        int N, M;
        int[][] maze;
        int[] hole;

        public class Node implements Comparable<Node> {
            int x, y, dist;
            String path;

            Node(int x, int y, int dist, String path) {
                this.x = x;
                this.y = y;
                this.dist = dist;
                this.path = path;
            }

            @Override
            public int compareTo(Node other) {
                if (this.dist == other.dist) return this.path.compareTo(other.path);
                return Integer.compare(this.dist, other.dist);
            }
        }

        public List<int[]> getNextCords(int row, int col) {
            List<int[]> cords = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                int dist = 0;
                int nx = row, ny = col;
                while (nx + dx[i] >= 0 && ny + dy[i] >= 0 && nx + dx[i] < N && ny + dy[i] < M && maze[nx + dx[i]][ny + dy[i]] != 1) {
                    nx += dx[i];
                    ny += dy[i];
                    dist++;
                    if (nx == hole[0] && ny == hole[1]) {
                        cords.add(new int[]{nx, ny, dist, 1});
                        return cords;
                    }
                }
                cords.add(new int[]{nx, ny, dist, 0});
            }
            return cords;
        }

        public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
            N = maze.length;
            M = maze[0].length;
            this.maze = maze;
            this.hole = hole;

            PriorityQueue<Node> pq = new PriorityQueue<>();
            String[][] visited = new String[N][M];
            pq.add(new Node(ball[0], ball[1], 0, "")); // x, y, dist, path

            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                int x = cur.x, y = cur.y, dist = cur.dist;
                String path = cur.path;

                if (x == hole[0] && y == hole[1]) return path;

                if (visited[x][y] != null && (visited[x][y].length() < path.length() ||
                        (visited[x][y].length() == path.length() && visited[x][y].compareTo(path) <= 0))) {
                    continue;
                }
                visited[x][y] = path;

                List<int[]> nextCords = getNextCords(x, y);
                for (int i = 0; i < nextCords.size(); i++) {
                    int[] next = nextCords.get(i);
                    int nx = next[0], ny = next[1], nextDist = dist + next[2];
                    pq.add(new Node(nx, ny, nextDist, path + dirs[i]));
                }
            }
            return "impossible";
        }
    }


}
