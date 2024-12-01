package Leetcode;

public class Q904 {
    class Solution {
        public int totalFruit(int[] fruits) {
            int N = fruits.length;
            int[] counter = new int[N];
            int kinds = 0;
            int left = 0;
            int ans = 0;

            for (int right = 0; right < N; right++) {
                if (counter[fruits[right]]++ == 0) kinds++;

                while (kinds > 2) if (--counter[fruits[left++]] == 0) kinds--;

                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }
    }
}
