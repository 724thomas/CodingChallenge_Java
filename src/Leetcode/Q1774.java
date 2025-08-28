package Leetcode;

/*
1. 아이디어 :
n, m <= 10 이므로 완전 탐색이 가능
백트래킹을 사용하고 종료 조건은:
- ans == target일때 종료
- 현재비용 > target이고, 현재비용 - target >= minDiff일때 종료
- idx == m일때 종료
업데이트 조건은:
- 현재비용 == target일때 ans = 현재비용
- 현재비용 > target일때, 현재비용 - target < minDiff일때 minDiff, ans 업데이트
- 현재비용 < target일때, target - 현재비용 <= minDiff일때 minDiff, ans 업데이트

2. 시간복잡도 :
O( n * 3^m )

3. 자료구조/알고리즘 :
배열 / 백트래킹
 */

public class Q1774 {
    class Solution {
        int ans;
        int minDiff;
        int target;
        int[] baseCosts, toppingCosts;
        int n, m;

        public void backtrack(int totalCost, int idx) {
            if (ans == target) return;
            if (totalCost == target) {
                ans = totalCost;
                return;
            } else if (totalCost > target) {
                if (totalCost - target >= minDiff) return;
                minDiff = totalCost - target;
                ans = totalCost;
            } else if (totalCost < target) {
                if (target-totalCost <= minDiff) {
                    minDiff = target - totalCost;
                    ans = totalCost;
                }
            }
            if (idx == m) return;

            backtrack(totalCost, idx+1);
            backtrack(totalCost + toppingCosts[idx], idx+1);
            backtrack(totalCost + toppingCosts[idx] * 2, idx+1);
        }

        public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
            minDiff = Integer.MAX_VALUE;
            this.target = target;
            this.baseCosts = baseCosts;
            this.toppingCosts = toppingCosts;
            n = baseCosts.length;
            m = toppingCosts.length;
            ans = 0;

            for (int baseCost : baseCosts) {
                if (baseCost == target) return target;
                backtrack(baseCost, 0);
            }
            return ans;
        }
    }
}
