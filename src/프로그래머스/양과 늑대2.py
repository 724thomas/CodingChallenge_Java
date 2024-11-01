# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    백트래킹을 통해서 모든 경우의 수를 탐색.
    dfs로 하게되면 해당 노드로만 진입함으로 정답이 안나옴.
    백트래킹은 15가 최대이지만,실제로는 17이하.
2. 시간복잡도 :
    O(2 ** n)
3. 자료구조 :
    해시셋

import java.util.*;
class Solution {
    Set<Integer> visited = new HashSet<>();
    int ans = 0;

    public void backtrack(int[] info, int[][] edges, int sheepCount, int wolfCount) {
        if (sheepCount <= wolfCount) return;

        ans = Math.max(ans, sheepCount);

        for (int[] edge: edges) {
            int par = edge[0], child = edge[1];
            if (visited.contains(par) && !visited.contains(child)){
                visited.add(child);

                if (info[child] == 0) { // if sheep
                    backtrack(info, edges, sheepCount+1, wolfCount);
                } else { // if wolf
                    backtrack(info, edges, sheepCount, wolfCount+1);
                }

                visited.remove(child);
            }
        }
    }

    public int solution(int[] info, int[][] edges) {
        visited.add(0);
        backtrack(info, edges, 1, 0);
        return ans;
    }
}

'''


from collections import defaultdict, deque
def solution(info, edges):
    def backtrack(sheep, wolf):
        if sheep<= wolf:
            return

        ans[0] = max(ans[0], sheep)

        for par, child in edges:
            if par in visited and child not in visited:
                visited.add(child)

                if info[child]:
                    backtrack(sheep, wolf+1)
                else:
                    backtrack(sheep+1, wolf)
                visited.remove(child)

    visited = set()
    visited.add(0)
    ans = [0]
    backtrack(1, 0)
    return ans[0]