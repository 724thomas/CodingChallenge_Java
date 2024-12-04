# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    int[] dx = new int[]{1,-1,0,0};
    int[] dy = new int[]{0,0,1,-1};
    int N;
    int M;

    public Set<String> nextCords(int[][] board, int cx, int cy) {
        Set<String> candids = new HashSet<>();

        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i], ny = cy + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                candids.add(nx + " " + ny);
            }

            int mx = cx, my = cy;
            while (true) {
                mx += dx[i];
                my += dy[i];
                if (mx < 0 || mx >= N || my < 0 || my >= M) {
                    mx -= dx[i];
                    my -= dy[i];
                    break;
                }
                if (board[mx][my] != 0) break;
            }
            candids.add(mx + " " + my);
        }
        return candids;
    }

    public void permute(List<Integer> nums, int start, List<List<Integer>> ans) {
        if (start == nums.size()-1) {
            ans.add(new ArrayList<>(nums));
            return;
        }
        for (int i= start; i<nums.size(); i++) {
            Collections.swap(nums, i, start);
            permute(nums, start + 1, ans);
            Collections.swap(nums, i, start);
        }
    }

    public int getMinDistance(int[][] board, int startX, int startY, int endX, int endY) {
        boolean[][] visited = new boolean[4][4];
        visited[startX][startY] = true;
        Deque<int[]> queue = new LinkedList<>(); //row, col, dist
        queue.add(new int[]{startX, startY, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0], cy = curr[1], cd = curr[2];
            if (cx == endX && cy == endY) return cd;
            for (String nextCord : nextCords(board, cx, cy)) {
                int[] nxny = Arrays.stream(nextCord.split(" ")).mapToInt(Integer::parseInt).toArray();
                int nx = nxny[0], ny = nxny[1], nd = cd+1;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, nd});
            }
        }
        return -1;
    }

    public int backtrack(int[][] board, int r, int c, List<Integer> permute, Map<Integer, ArrayList<int[]>> charCords, int idx) {
        if (idx == permute.size()) return 0;

        int card = permute.get(idx);
        int[] first = charCords.get(card).get(0);
        int[] second = charCords.get(card).get(1);

        int dist1 = getMinDistance(board,r,c,first[0],first[1]) + getMinDistance(board, first[0], first[1], second[0], second[1]);
        int dist2 = getMinDistance(board,r,c,second[0],second[1]) + getMinDistance(board, second[0], second[1], first[0], first[1]);

        board[first[0]][first[1]] = 0;
        board[second[0]][second[1]] = 0;

        int cost1 = dist1 + 2 + backtrack(board, second[0], second[1], permute, charCords, idx+1);
        int cost2 = dist2 + 2 + backtrack(board, first[0], first[1], permute, charCords, idx+1);

        board[first[0]][first[1]] = card;
        board[second[0]][second[1]] = card;

        return Math.min(cost1, cost2);
    }

    public int solution(int[][] board, int r, int c) {
        N = board.length;
        M = board[0].length;

        boolean[] checked = new boolean[7];
        List<Integer> nums = new ArrayList<>();
        Map<Integer, ArrayList<int[]>> charCords = new HashMap<>();

        for (int i=0; i<N; i++) for (int j=0; j<M; j++) {
            int num = board[i][j];
            if (num == 0) continue;
            if (!checked[num]) {
                checked[num] = true;
                nums.add(num);
            }
            charCords.putIfAbsent(num, new ArrayList<>());
            charCords.get(num).add(new int[]{i, j});
        }

        List<List<Integer>> permutes = new ArrayList<>();
        permute(nums, 0, permutes);

        int ans = Integer.MAX_VALUE;
        for (List<Integer> permute : permutes) {
            ans = Math.min(ans, backtrack(board, r, c, permute, charCords, 0));
        }
        return ans;
    }
}
'''



