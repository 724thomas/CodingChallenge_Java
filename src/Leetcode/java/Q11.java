package Leetcode.java;

import java.util.ArrayList;
import java.util.HashMap;

public class  Q11 {
    class Solution {
        public int maxArea(int[] height) {
            var n = height.length;
            var left = 0;
            var right = n-1;

            int ans = 0;
            while (left<right) {
                var lheight = height[left];
                var rheight = height[right];
                var area = Math.min(lheight, rheight) * (right-left);
                ans = Math.max(ans, area);
                if (lheight < rheight) {
                    left++;
                } else {
                    right--;
                }
            }
            return ans;
        }
    }
    class Solution2 {
        public int[] solution(String[] genres, int[] plays) {
            var n = genres.length;
            var genreMap = new HashMap<String, ArrayList<int[]>>();
            for (int i=0; i<n; i++) {
                var genre = genres[i];
                var play = plays[i];
                genreMap.putIfAbsent(genre, new ArrayList<>());
                genreMap.get(genre).add(new int[]{play, i});
            }


            int[] answer = {};
            return answer;
        }
    }
}


