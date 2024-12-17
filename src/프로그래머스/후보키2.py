# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    -
2. 시간복잡도 :
    O(    )
3. 자료구조 :
    -
import java.util.*;
class Solution {
    List<List<Integer>> candid = new ArrayList<>();
    int N;
    int M;
    Set<String> visited;
    StringBuilder minimumSb;
    Set<String> minimum;
    StringBuilder sb;

    public void backtrack(int idx, List<Integer> curr) {
        candid.add(new ArrayList<>(curr));
        if (idx == M) return;

        for (int i=idx+1; i<M; i++) {
            curr.add(i);
            backtrack(i, curr);
            curr.remove(curr.size()-1);
        }
    }

    public boolean check(List<Integer> c, String[][] relation) {
        visited = new HashSet<>();
        for (String[] r : relation) {
            sb = new StringBuilder();
            for (int field : c) {
                sb.append(r[field]).append(" - ");
            }
            if (!visited.add(sb.toString())) {
                return false;
            }
        }
        return true;
    }

    private boolean checkMinimal(List<List<Integer>> keys) {
        for (int i = 0; i < keys.size(); i++) {
            for (int j = 0; j < keys.size(); j++) {
                if (i != j && keys.get(i).containsAll(keys.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public int solution(String[][] relation) {
        N = relation.length;
        M = relation[0].length;
        backtrack(-1, new ArrayList<>());
        minimum = new HashSet<>();

        List<List<Integer>> keys = new ArrayList<>();

        for (List<Integer> c : candid) {
            boolean unique = check(c, relation);
            if (!unique) continue;
            keys.add(c);
        }

        while (!checkMinimal(keys)) {
            for (int i = 0; i < keys.size(); i++) {
                for (int j = 0; j < keys.size(); j++) {
                    if (i != j && keys.get(i).containsAll(keys.get(j))) {
                        keys.remove(i);
                    }
                }
            }
        }

        int ans = keys.size();
        return ans;
    }
}

'''



