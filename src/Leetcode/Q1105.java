package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q1105 {
    class Solution {
        Map<Integer, Integer> cache = new HashMap<>();

        public int dp(int[][] books, int shelfWidth, int idx) {
            if (idx == books.length) return 0;
            if (cache.containsKey(idx)) return cache.get(idx);

            int currWidth = shelfWidth;
            int maxHeight = 0;
            int ans = Integer.MAX_VALUE;

            for (int i = idx; i<books.length; i++) {
                int width = books[i][0], height= books[i][1];
                if (currWidth < width) break;

                currWidth -= width;
                maxHeight = Math.max(maxHeight, height);
                ans = Math.min(ans, dp(books, shelfWidth, i+1) + maxHeight);
            }
            cache.put(idx, ans);
            return ans;
        }

        public int minHeightShelves(int[][] books, int shelfWidth) {
            return dp(books, shelfWidth, 0);
        }
    }
}
