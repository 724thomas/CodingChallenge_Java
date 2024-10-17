# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    List<List<Integer>> combinations = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    int req;
    int spent;

    public void get_combinations(ArrayList<Integer> path, int n) {
        if (path.size() == n) {
            combinations.add(new ArrayList<>(path));
            return;
        }
        for (int i=0; i<n; i++) {
            if (visited.contains(i)) continue;
            visited.add(i);
            path.add(i);
            get_combinations(path, n);
            path.remove(path.size()-1);
            visited.remove(i);
        }

    }
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length, ans = 0;
        get_combinations(new ArrayList<>(), n);
        for (var combination:combinations){
            int temp_k = k, temp_ans = 0;
            for (Integer i : combination) {
                req = dungeons[i][0];
                spent = dungeons[i][1];
                if (temp_k >= req) {
                    temp_ans++;
                    temp_k -= spent;
                } else {
                    break;
                }
            }
            ans = Math.max(ans, temp_ans);
        }
        return ans;
    }
}

'''

from itertools import permutations
def solution(k, dungeons):
    n, ans = len(dungeons), 0
    combs = permutations(dungeons, n)
    for c in combs:
        temp_k, temp_ans = k, 0
        for req, spent in c:
            if temp_k >= req:
                temp_k -= spent
                temp_ans+=1
            else:
                break
        ans = max(ans, temp_ans)
    return ans
