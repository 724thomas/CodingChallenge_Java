package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q2250 {
    class Solution {
        public int binarySearch(List<Integer> list, int target) {
            int left = 0, right = list.size();
            while (left<right) {
                int mid = left + (right-left)/2;
                if (list.get(mid) < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;

        }
        public int[] countRectangles(int[][] rectangles, int[][] points) {
            int n = rectangles.length, m = points.length;
            int[] ans = new int[m];

            Map<Integer, List<Integer>> heightWidth = new HashMap<>();
            // 키: height, 값: widths 오른차순. 높이<=100

            Arrays.sort(rectangles, (a, b) -> a[0] - b[0]);
            for (int [] r : rectangles) {
                int w = r[0], h = r[1];
                heightWidth.putIfAbsent(h, new ArrayList<>());
                heightWidth.get(h).add(w);
            }

            for (int i=0; i<m; i++) {
                int x = points[i][0], y = points[i][1];
                int count = 0;

                for (int height = y; height <= 100; height++) {
                    if (!heightWidth.containsKey(height)) continue;
                    List<Integer> widths = heightWidth.get(height);

                    int idx = binarySearch(widths, x);
                    count += widths.size() - idx;
                }

                ans[i] = count;
            }

            return ans;
        }
    }
}
