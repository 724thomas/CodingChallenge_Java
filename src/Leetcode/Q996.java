package Leetcode;

/*
1. 아이디어 :
모든 조합을 구하는 백트래킹 문제. 다만, 중복된 데이터가 있음.
정렬하고, 중복된 데이터는 건너뛰면서 백트래킹을 진행.

2. 시간복잡도 :
O( 2**n )

3. 자료구조/알고리즘 :
- / 백트래킹
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q996 {
    class Solution {
        int n;
        int[] nums;
        int ans = 0;
        boolean[][] perfect;

        public boolean isPerfect(int num) {
            int sqrt = (int)Math.sqrt(num);
            return sqrt * sqrt == num;
        }

        public void backtrack(List<Integer> candid, boolean[] visited) {
            if (candid.size() == n) {
                ans++;
                return;
            }

            int prev = candid.get(candid.size()-1);
            for (int next = 0; next<n; next++) {
                if (visited[next] || !perfect[prev][next]) continue;
                if (next > 0 && nums[next-1] == nums[next] && !visited[next-1]) continue;

                visited[next] = true;
                candid.add(next);

                backtrack(candid, visited);

                candid.remove(candid.size()-1);
                visited[next] = false;

            }
        }

        public int numSquarefulPerms(int[] nums) {
            Arrays.sort(nums);
            n = nums.length;
            this.nums = nums;
            perfect = new boolean[n][n];
            for (int i=0; i<n; i++) for (int j=i+1; j<n; j++) {
                if (isPerfect(nums[i] + nums[j])) {
                    perfect[i][j] = true;
                    perfect[j][i] = true;
                }
            }

            boolean[] visited = new boolean[n];
            List<Integer> candid = new ArrayList<>();

            for (int i=0; i<n; i++) {
                if (i > 0 && nums[i-1] == nums[i]) continue;
                visited[i] = true;
                candid.add(i);
                backtrack(candid, visited);
                candid.remove(candid.size()-1);
                visited[i] = false;
            }

            return ans;
        }
    }
}
