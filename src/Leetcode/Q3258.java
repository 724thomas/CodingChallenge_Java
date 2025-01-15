package Leetcode;

public class Q3258 {
    class Solution {
        int[] counter;
        public int countKConstraintSubstrings(String s, int k) {
            int ans = 0;
            for (int i=0; i<s.length(); i++) {
                counter = new int[2];
                for (int j=i; j<s.length(); j++) {
                    counter[Integer.parseInt(s.charAt(j)+"")]++;
                    if (counter[0] <= k || counter[1] <= k) ans++;
                }
            }

            return ans;
        }
    }
}
