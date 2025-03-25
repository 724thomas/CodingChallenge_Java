package Leetcode;

/*
1. 아이디어 :
dfs를 사용했습니다.
자식 노드부터 부모 노드로 올라가면서, 각 노드에서의 최대값을 구합니다.
모든 값을 유지하게 되면 시간초과가 발생합니다.
최대값 3개, 최소값 3개를 유지합니다.
최소값을 유지하는 이유는, 음수 * 음수 = 양수가 될 수 있기 때문입니다.

2. 시간복잡도 :
O( n * (2mlogm + 2mlogm) ) = O( n * mlogm ) (n: 노드의 개수, m: 큐 내부의 최대 크기)

3. 자료구조/알고리즘 :
해시맵, 우선순위큐 / dfs
 */

import java.util.*;

public class Q2973 {
    class Pair {
        PriorityQueue<Integer> pos;
        PriorityQueue<Integer> neg;

        public Pair (PriorityQueue<Integer> pos, PriorityQueue<Integer> neg) {
            this.pos = pos;
            this.neg = neg;
        }
    }
    class Solution {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Long> ans = new HashMap<>();
        int[] cost;

        public Long getMax(PriorityQueue<Integer> pos, PriorityQueue<Integer> neg) {
            List<Integer> maxList = new ArrayList<>(pos);
            Collections.sort(maxList, Collections.reverseOrder());
            List<Integer> minList = new ArrayList<>(neg);
            Collections.sort(minList);

            long cmax1 = 1L;
            long cmax2 = 1L;
            if (maxList.size() >= 3) {
                cmax1 = 1L * maxList.get(0) * maxList.get(1) * maxList.get(2);
                cmax2 = 1L * maxList.get(0) * minList.get(0) * minList.get(1);
            }
            return Math.max(cmax1, cmax2);
        }

        public Pair dfs(int node, int parent) {
            PriorityQueue<Integer> childValPos = new PriorityQueue<>();
            PriorityQueue<Integer> childValNeg = new PriorityQueue<>((a,b) -> b-a);
            childValPos.add(cost[node]);
            childValNeg.add(cost[node]);

            List<Integer> children = map.getOrDefault(node, new ArrayList<>());
            for (int child : children) {
                if (child == parent) continue;
                Pair pair = dfs(child, node);
                PriorityQueue<Integer> posVals = new PriorityQueue<>(pair.pos);
                PriorityQueue<Integer> negVals = new PriorityQueue<>(pair.neg);

                for (int val : posVals) {
                    childValPos.add(val);
                    if (childValPos.size() > 3) childValPos.poll();
                }
                for (int val : negVals) {
                    childValNeg.add(val);
                    if (childValNeg.size() > 3) childValNeg.poll();
                }
            }

            long nodeVal = getMax(childValPos, childValNeg);
            ans.put(node, Math.max(nodeVal, 0));

            return new Pair(childValPos, childValNeg);
        }

        public long[] placedCoins(int[][] edges, int[] cost) {
            this.cost = cost;
            for (int[] e : edges) {
                int u = e[0], v = e[1];
                map.putIfAbsent(u, new ArrayList<>());
                map.putIfAbsent(v, new ArrayList<>());
                map.get(u).add(v);
                map.get(v).add(u);
            }
            dfs(0, -1);
            // System.out.println(ans);
            // Arrays.sort(cost);

            long[] ansArray = new long[ans.size()];
            for (int i=0; i<ans.size(); i++) {
                ansArray[i] = ans.get(i);
            }

            return ansArray;

        }
    }
}
