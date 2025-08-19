// https://www.acmicpc.net/problem/
package 백준;

/*
1. 아이디어 :
- union-find로 모든 길들을 합치면서 출발지 도착지가 같은 집합인지 확인
- 다익스트라로 출발지에서 도착지까지 가는 길 중 가장 넓은 길을 찾기

2. 시간복잡도 :
O( E log E )
O( V + E log V )

3. 자료구조/알고리즘 :
해시셋, 해시맵, 우선순위큐 / 다익스트라, union-find

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q11085 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] par;
    static int[][] widths;
    static Map<Integer, Set<Integer>> graph;
    static int start, end;

    private static int find(int a) {
        if (par[a] != a) par[a] = find(par[a]);
        return par[a];
    }

    private static void union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return;
        par[rb] = ra;
    }

    public static void main(String[] args) throws IOException {
        String[] inputs = br.readLine().split(" ");
        int points = Integer.parseInt(inputs[0]);
        int paths = Integer.parseInt(inputs[1]);
        inputs = br.readLine().split(" ");
        start = Integer.parseInt(inputs[0]);
        end = Integer.parseInt(inputs[1]);

        widths = new int[points][points];
        graph = new HashMap<>();

        for (int i=0; i<paths; i++) {
            int[] path = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int u =path[0], v = path[1], width = path[2];
            widths[u][v] = Math.max(widths[u][v], width);
            widths[v][u] = Math.max(widths[v][u], width);
            graph.putIfAbsent(u, new HashSet<>());
            graph.putIfAbsent(v, new HashSet<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }


        // union-find 방식
        par = new int[points];
        for (int i=0; i<points; i++) {
            par[i] = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b ) -> Integer.compare(b[2], a[2])); // u, v, width desc
        for (int i=0; i<points; i++) for (int j=0; j<points; j++) {
            if (widths[i][j] > 0) {
                pq.add(new int[]{i, j, widths[i][j]});
            }
        }

        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            int u = c[0], v = c[1], width = c[2];
            union(u, v);
            if (find(start) == find(end)) {
                System.out.println(width);
                return;
            }
        }

        /* 다익스트라 방식
        int[] dist = new int[points];
        Arrays.fill(dist, -1);
        dist[start] = Integer.MAX_VALUE;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b ) -> Integer.compare(b[1], a[1])); // node, width desc
        pq.add(new int[]{start, dist[start]});

        boolean visited[] = new boolean[points];

        while (!pq.isEmpty()) {
            int[] widest = pq.poll();
            int curr = widest[0], currWidth = widest[1];

            if (visited[curr]) continue;
            visited[curr] = true;

            if (curr == end) {
                System.out.println(currWidth);
                return;
            }

            for (int neighbor : graph.getOrDefault(curr, new HashSet<>())) {
                if (visited[neighbor]) continue;
                int neighborWidth = widths[curr][neighbor];
                if (neighborWidth == 0) continue;

                int newWidth = Math.min(currWidth, neighborWidth);
                if (newWidth > dist[neighbor]) {
                    dist[neighbor] = newWidth;
                    pq.add(new int[]{neighbor, newWidth});
                }
            }
        }
         */
    }
}
