// https://www.acmicpc.net/problem/
package 백준;

/*
1. 아이디어 :
bfs

2. 시간복잡도 :
O( n^2 + q )

3. 자료구조/알고리즘 :
해시맵 / bfs
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q14588 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static boolean isFriend(int[] a, int[] b) {
        if (a[1] < b[0] || b[1] < a[0]) {
            return false; // No overlap
        }
        return true;
    }

    static int[][] dist;
    static Map<Integer, List<Integer>> graph = new HashMap<>();

    private static void bfs(int start, boolean[] visited) {
        visited[start] = true;
        Deque<int[]> deque = new ArrayDeque<>(); // node, distance;
        deque.add(new int[]{start, 0});
        while (!deque.isEmpty()) {
            int[] c = deque.poll();
            int node = c[0], distance = c[1];

            dist[start][node] = distance;
            dist[node][start] = distance;

            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (visited[neighbor]) continue;
                visited[neighbor]=true;
                deque.add(new int[]{neighbor, distance+1});
            }
        }
    }
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<int[]> cords = new ArrayList<>();
        for (int i=0; i<n; i++) {
            int[] cord = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            cords.add(cord);
        }
        dist = new int[n][n];
        for (int i=0; i<n; i++) Arrays.fill(dist[i], -1);

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (isFriend(cords.get(i), cords.get(j))) {
                    graph.putIfAbsent(i, new ArrayList<>());
                    graph.putIfAbsent(j, new ArrayList<>());
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        for (int i=0; i<n; i++) {
            bfs(i, new boolean[n]);
        }
//        for (var a : dist) System.out.println(Arrays.toString(a));

        int q = Integer.parseInt(br.readLine());
        for (int i=0; i<q; i++) {
            int[] query = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            System.out.println(dist[query[0]-1][query[1]-1]);
        }
    }
}
