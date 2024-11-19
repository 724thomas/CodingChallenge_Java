# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public Set<Integer> permutations(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, "", ans, visited);
        return ans;
    }

    public void backtrack(int[] nums, String curr, Set<Integer> ans, boolean[] visited) {
        if (curr!="") {
            ans.add(Integer.parseInt(curr));
        }
        if (curr.length() == nums.length) {
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;

            backtrack(nums, curr + String.valueOf(nums[i]), ans, visited);

            visited[i] = false;
        }
    }

    public boolean check_prime(int n) {
        if (n < 2) return false;
        int sqrt = (int)Math.sqrt(n);

        for (int i=2; i<=sqrt; i++) {
            if (n%i==0) return false;
        }
        return true;
    }

    public int solution(String numbers) {
        int ans = 0;
        int[] nums = new int[numbers.length()];
        for (int i=0; i<numbers.length(); i++) {
            nums[i] = Integer.parseInt(numbers.charAt(i) + "");
        }
        for (int num : permutations(nums)) {
            ans += check_prime(num) ? 1 : 0;
        }
        return ans;
    }
}
'''



