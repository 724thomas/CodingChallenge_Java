package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1514 {
    class Solution {
        // bellman-ford: O(n + 2m)
        public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
            int m = edges.length;
            double[] maxProbs = new double[n];
            maxProbs[start_node] = 1;

            for (int i=0; i<=n; i++) { // n
                boolean found = false;
                double[] tempProbs = maxProbs.clone(); // m
                for (int j=0; j<m; j++) { // m
                    int[] edge = edges[j];
                    int u = edge[0], v = edge[1];
                    double prob = succProb[j];

                    if (tempProbs[v] < maxProbs[u] * prob) {
                        tempProbs[v] = maxProbs[u] * prob;
                        found = true;
                    }
                    if (tempProbs[u] < maxProbs[v] * prob) {
                        tempProbs[u] = maxProbs[v] * prob;
                        found = true;
                    }
                }

                if (!found) break;
                maxProbs = tempProbs;
            }

            return maxProbs[end_node];
        }
    /*
    // daijkstra: O(nlogn * m)
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        int m = edges.length;
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i=0; i<m; i++) { // m
            int[] edge = edges[i];
            int u = edge[0], v = edge[1];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(new int[]{v, i});
            graph.get(v).add(new int[]{u, i});
        }

        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> {
            return Double.compare(b[1], a[1]);
        }); // currNode, currProb
        pq.add(new double[]{start_node, 1});
        double[] probs = new double[n];
        probs[start_node] = 1;
        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) { // nlogn * m
            double[] c = pq.poll();
            int cNode = (int)c[0];
            double cProb = c[1];

            if (cProb > probs[cNode] || visited[cNode]) continue;
            if (cNode == end_node) return cProb;
            visited[cNode] = true;

            for (int[] neighbor : graph.getOrDefault(cNode, new ArrayList<>())) { // m
                int nNode = neighbor[0];
                double nProb = succProb[neighbor[1]];
                if (probs[nNode] > cProb * nProb || visited[nNode]) continue;
                probs[nNode] = cProb * nProb;
                pq.add(new double[]{nNode, cProb * nProb});
            }
        }

        return 0;
    }
    */
    }
}
