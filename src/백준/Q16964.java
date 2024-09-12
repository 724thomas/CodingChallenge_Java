package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Q16964 {
    static int idx = 1;

    static boolean dfs(int curr, HashMap<Integer, ArrayList<Integer>> map, int[] order, boolean[] visited) {
        visited[curr] = true;

        HashSet<Integer> neighbors = new HashSet<>(map.get(curr));

        while (idx < order.length && neighbors.contains(order[idx])) {
            int next = order[idx];
            idx++;
            if (!dfs(next, map, order, visited)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String[] inputs = br.readLine().split(" ");
            int u = Integer.parseInt(inputs[0]), v = Integer.parseInt(inputs[1]);
            map.get(u).add(v);
            map.get(v).add(u);
        }

        String[] inputs = br.readLine().split(" ");
        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            order[i] = Integer.parseInt(inputs[i]);
        }

        if (order[0] != 1) {
            System.out.println(0);
            return;
        }

        boolean[] visited = new boolean[n + 1];

        if (dfs(1, map, order, visited) && idx == n) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}