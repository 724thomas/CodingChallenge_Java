# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    Map<String, ArrayList<String>> graph;
    HashMap<String,Integer> left;
    ArrayList<String> candid;

    public void backtrack(ArrayList<String> path, String curr, int visited, int n){
        if (visited == n){
            candid.add(String.join("-", path));
            return;
        }
        if (!graph.containsKey(curr)) return;
        for (String dest : graph.get(curr)){
            String key = curr + "-" + dest;
            if (left.get(key) == 0) continue;

            left.put(key, left.get(key)-1);
            path.add(dest);

            backtrack(path, dest, visited+1, n);

            path.remove(path.size()-1);
            left.put(key, left.get(key)+1);
        }
    }

    public String[] solution(String[][] tickets) {
        graph = new HashMap<>();
        left = new HashMap<>();
        candid = new ArrayList<>();

        for (String[] ticket : tickets){
            String key = ticket[0] + "-" + ticket[1];
            graph.putIfAbsent(ticket[0], new ArrayList<>());
            graph.get(ticket[0]).add(ticket[1]);
            left.put(key, left.getOrDefault(key, 0)+1);
        }

        ArrayList<String> path = new ArrayList<>();
        path.add("ICN");
        backtrack(path, "ICN", 0, tickets.length);
        Collections.sort(candid);
        return candid.get(0).split("-");
    }
}

'''


