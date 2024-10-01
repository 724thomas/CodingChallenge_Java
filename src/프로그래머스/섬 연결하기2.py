# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
// 5000 * 100
    int[] par;
    int[] rank;

    public int find(int x) {
        if (x != par[x]) {
            par[x] = find(par[x]);
        }
        return par[x];
    }

    public boolean union(int a, int b){
        int ra = find(a), rb = find(b);
        if (ra == rb) return true;

        if (rank[ra] > rank[rb]) {
            par[rb] = ra;
        } else if (rank[ra] < rank[rb]) {
            par[ra] = rb;
        } else {
            par[rb] = ra;
            rank[ra] ++;
        }
        return false;
    }

    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        int ans = 0, edges = 0;
        par = new int[n];
        rank = new int[n];
        for (int i=0; i<n; i++) par[i] = i;

        for (int[] cost : costs) {
            int u = cost[0], v = cost[1], c = cost[2];
            if (!union(u, v)){
                ans += c;
                edges ++;
            }
            if (edges == n-1) return ans;
        }
        return -1;
    }
}

'''


