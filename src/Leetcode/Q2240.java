package Leetcode;

/*
1. 아이디어 :
트리를 구성.
모든 노드의 합과 최대값을 구하고, 최대값과 합을 순회하면서 k로 나누어 떨어지는지 확인.
나누어 떨어지면, dfs.
dfs에서 해당 노드 또는 노드와 자식들의 합이 target이면 서브트리 카운트를 올리고, 합 0을 리턴.

2. 시간복잡도 :
O( m + n * n  )

3. 자료구조/알고리즘 :
- / dfs
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2240 {
    class Solution {
        int[] nums;
        Map<Integer, List<Integer>> tree = new HashMap<>();
        int count = 0;

        public int dfs(int node, int parent, int target) {
            int sum = nums[node];
            for (int neighbor: tree.getOrDefault(node, new ArrayList<>())) {
                if (neighbor == parent) continue;
                sum += dfs(neighbor, node, target);
            }
            if (sum == target) {
                count++;
                return 0;
            }
            return sum;
        }

        public int componentValue(int[] nums, int[][] edges) {
            this.nums = nums;

            for (int[] e : edges) {
                int u = e[0], v = e[1];
                tree.putIfAbsent(u, new ArrayList<>());
                tree.putIfAbsent(v, new ArrayList<>());
                tree.get(u).add(v);
                tree.get(v).add(u);
            }

            int sum = 0, cmax = 0;
            for (int num : nums) {
                sum += num;
                cmax = Math.max(cmax, num);
            }

            for (int i=cmax; i<=sum; i++) {
                if (sum%i!=0) continue;
                count = 0;
                dfs(0,-1, i);
                if (sum / i == count) return count-1;
            }
            return 0;
        }
    }
}
