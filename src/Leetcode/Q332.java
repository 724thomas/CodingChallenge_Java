package Leetcode;

import java.util.*;

public class Q332 {
    class Solution {
        Map<String, PriorityQueue<String>> graph;
        LinkedList<String> ans;

        public List<String> findItinerary(List<List<String>> tickets) {
            graph = new HashMap<>();
            ans = new LinkedList<>();

            for (List<String> ticket : tickets) {
                graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
                graph.get(ticket.get(0)).offer(ticket.get(1));
            }

            dfs("JFK");
            return ans;
        }

        private void dfs(String airport) {
            while (graph.containsKey(airport) && !graph.get(airport).isEmpty()) {
                String nextAirport = graph.get(airport).poll();
                dfs(nextAirport);
            }

            ans.addFirst(airport);
        }
    }

}
