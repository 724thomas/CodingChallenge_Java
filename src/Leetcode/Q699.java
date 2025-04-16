package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q699 {
    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Solution {
        public List<Integer> fallingSquares(int[][] positions) {
            int n = positions.length;
            List<Integer> ans = new ArrayList<>();
            Map<Pair, Integer> squares = new HashMap<>(); //left, right : height

            int curr = 0;
            for (int i=0; i<n; i++) {
                int[] pos = positions[i];
                int left = pos[0], right = pos[0] + pos[1]; //2, 5

                int maxHeightInStack = pos[1];
                Map<Pair, Integer> squares2 = new HashMap<>();

                for (var square : squares.entrySet()) {
                    Pair key = square.getKey();
                    int sleft = key.x, sright = key.y, height = square.getValue(); // 1,3, 2

                    if (right <= sleft || sright <= left) {
                        squares2.put(key, height);
                        continue;
                    }

                    // 겹치는 애들은 다시 계산.
                    // 겹치지 않는 부분은 그대로 냅둔다.
                    maxHeightInStack = Math.max(maxHeightInStack, square.getValue() + pos[1]);
                    if ( left <= sleft && sright <= right) { //감싸는 경우

                    } else if (sleft <= left && right <= sright) { // 감싸지는 경우
                        int newLeft1 = sleft, newRight1 = left;
                        squares2.put(new Pair(newLeft1, newRight1), height);
                        int newLeft2 = right, newRight2 = sright;
                        squares2.put(new Pair(newLeft2, newRight2), height);
                    } else if (left <= sleft && right <= sright) { // 왼쪽으로 더 긴 경우
                        int newLeft2 = right, newRight2 = sright;
                        squares2.put(new Pair(newLeft2, newRight2), height);
                    } else if (sleft <= left && sright <= right) { // 오른쪽으로 더 긴 경우
                        int newLeft1 = sleft, newRight1 = left;
                        squares2.put(new Pair(newLeft1, newRight1), height);
                    }
                }
                squares2.put(new Pair(left, right), maxHeightInStack);
                curr = Math.max(curr, maxHeightInStack);
                squares = squares2;

                ans.add(curr);
            }
            return ans;
        }
    }
}
