package Leetcode.java;

import java.util.List;

public class Q624 {
    class Solution {
        public int maxDistance(List<List<Integer>> arrays) {
            int smallest = arrays.get(0).get(0);
            int biggest = arrays.get(0).get(arrays.get(0).size()-1);
            int ans = 0;
            for (int i=1; i<arrays.size(); i++) {
                var array = arrays.get(i);
                ans = Math.max(ans, Math.abs(array.get(0)-biggest));
                ans = Math.max(ans, Math.abs(array.get(array.size()-1) - smallest));
                smallest = Math.min(smallest, array.get(0));
                biggest = Math.max(biggest, array.get(array.size()-1));
            }

            return ans;
        }
    }
}
