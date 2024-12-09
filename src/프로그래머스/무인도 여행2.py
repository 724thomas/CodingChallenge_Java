# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    int N;
    int M;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    boolean[][] visited;

    public int bfs(String[] maps, int row, int col) {

        visited[row][col] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});

        int ans = Integer.parseInt(maps[row].charAt(col)+"");

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];

            for (int i=0; i<4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx<0 || ny <0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny] || maps[nx].charAt(ny) == 'X') continue;
                visited[nx][ny] = true;
                ans += Integer.parseInt(maps[nx].charAt(ny)+"");
                queue.add(new int[]{nx, ny});
            }
        }
        return ans;
    }

    public int[] solution(String[] maps) {
        List<Integer> ans = new ArrayList<>();
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];

        for (int row = 0; row<N; row++) for (int col = 0; col<M; col++) {
            if (maps[row].charAt(col) == 'X' || visited[row][col]) continue;
            ans.add(bfs(maps, row, col));
        }

        Collections.sort(ans);
        int[] ans2 = new int[ans.size()];
        for (int i=0; i<ans.size(); i++) ans2[i] = ans.get(i);
        return ans2.length == 0? new int[]{-1} : ans2;
    }
}
'''



