# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    dp + dfs로 풀었습니다.
    a 등대의 불이 켜져 있거나 꺼져있을때의 상태 저장
    a 등대 불이 켜져 있으면 b 등대는 불을 킬수도 끌 수도 있기때문에, a 등대의 불이 켜지거나 꺼졌을때의 최소값
    a 등대 불이 꺼져 있으면 b 등대는 불을 켜야하기 때문에, a 등대의 꺼졌을때의 값

    bfs로 풀게되면 문제는 풀리지만, 총 몇개의 등대가 켜져있는지 리프노드에서 찾기가 어려움

2. 시간복잡도 :
    O( n )
3. 자료구조 :
    해시셋, 해시맵, 2차원 dp 배열

import java.util.*;
class Solution {
    Map<Integer, ArrayList<Integer>> graph;
    int[][] dp;
    boolean[] visited;

    public void dfs(int curr, int par) {
        visited[curr] = true;
        dp[curr][0] = 0;
        dp[curr][1] = 1;

        for (int neighbor : graph.get(curr)) {
            if (visited[neighbor]) continue;

            dfs(neighbor, curr);
            dp[curr][0] += dp[neighbor][1];
            dp[curr][1] += Math.min(dp[neighbor][0], dp[neighbor][1]);
        }
    }

    public int solution(int n, int[][] lighthouse) {
        graph = new HashMap<>();
        for (int[] lh : lighthouse)  {
            int l1 = lh[0]-1, l2 = lh[1]-1;
            graph.putIfAbsent(l1, new ArrayList<>());
            graph.putIfAbsent(l2, new ArrayList<>());
            graph.get(l1).add(l2);
            graph.get(l2).add(l1);
        }

        dp = new int[n][2]; //on, off
        visited = new boolean[n];

        dfs(0, -1);

        return Math.min(dp[0][0], dp[0][1]);



        /*
        visited.add(start);
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.pollFirst();

            for (int neighbor : graph.get(curr)) {
                if (visited.contains(neighbor)) continue;
                visited.add(neighbor);
                dp[neighbor][0] = Math.min(dp[curr][1], dp[curr][0]) + 1; // on
                dp[neighbor][1] = dp[curr][0]; // off
                if (visited.size() == n+1) return Math.min(dp[neighbor][0], dp[neighbor][1]);
                queue.addLast(neighbor);
            }
        }

        for (int i=0; i<n; i++) System.out.println((i+1) + " " +Arrays.toString(dp[i]));
        return -1;
        */
    }
}
'''



