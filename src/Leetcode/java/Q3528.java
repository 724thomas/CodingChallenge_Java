package Leetcode.java;

/*
1. 아이디어 :
-bfs를 사용하여 풀 수 있습니다.
-0부터 시작하여 conversions에 있는 단위 변환을 따라가며 각 단위의 개수를 계산합니다.
-int 범위를 넘어갈 수 있으므로, source 갯수 * factor를 long으로 계산하고 MOD로 나눈 후 int로 변환합니다.

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
해시맵 / BFS
 */

import java.util.*;

public class Q3528 {
    class Solution {
        public int[] baseUnitConversions(int[][] conversions) {
            int n = conversions.length+1;
            int MOD = 1_000_000_007;
            Map<Integer, List<int[]>> graph = new HashMap<>();

            for (int[] c : conversions) {
                int source = c[0], target = c[1], factor = c[2];
                graph.putIfAbsent(source, new ArrayList<>());
                graph.get(source).add(new int[]{target, factor});
            }

            int[] counter = new int[n];
            counter[0] = 1;
            Deque<Integer> deque = new ArrayDeque<>();
            deque.add(0);

            while (!deque.isEmpty()) {
                int source = deque.pollFirst();
                int sourceCount = counter[source];
                for (int[] next : graph.getOrDefault(source, new ArrayList<>())) {
                    int target = next[0], factor = next[1];
                    counter[target] = (int)((long)sourceCount * factor % MOD);
                    deque.add(target);
                }
            }

            return counter;
        }
    }
}
