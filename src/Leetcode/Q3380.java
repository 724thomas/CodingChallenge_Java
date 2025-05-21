package Leetcode;

/*
1. 아이디어 :
백트래킹을 통해, 해당 점을 포함할지 포함하지 않을지 결정.
포인트 순회를 마치면, 현재까지 포함된 점이 4개인지 확인
4개의 점이 직사각형을 이루는지 확인. 아니면 -1 리턴(-1 = 유효하지 않은 조합)
모든 점을 순회하면서 4개의 점과 같지 않고, 내부에 있으면 -1.
넓이를 계산해서 리턴.
모든 조합에 대해 최대 넓이를 갱신

2. 시간복잡도 :
O(  2^n + 4 + 4n ) = 2^n

3. 자료구조/알고리즘 :
- / 백트래킹
 */

import java.util.ArrayList;
import java.util.List;

public class Q3380 {
    class Solution {
        int[][] points;
        List<List<int[]>> candids = new ArrayList<>();
        int n;
        int ans = -1;

        public int check(List<int[]> curr) {
            int xmax = Integer.MIN_VALUE;
            int xmin = Integer.MAX_VALUE;
            int ymax = Integer.MIN_VALUE;
            int ymin = Integer.MAX_VALUE;
            for (int[] c : curr) {
                xmax = Math.max(xmax, c[0]);
                xmin = Math.min(xmin, c[0]);
                ymax = Math.max(ymax, c[1]);
                ymin = Math.min(ymin, c[1]);
            }
            for (int[] c : curr) {
                if (c[0] != xmin && c[0] != xmax) return -1;
                if (c[1] != ymin && c[1] != ymax) return -1;
            }

            for (int[] p : points) {
                boolean isSame = false;
                for (int[] c : curr) {
                    if (p[0] == c[0] && p[1] == c[1]) isSame = true;
                }
                if (isSame) continue;
                if (xmin<=p[0] && p[0]<=xmax && ymin<=p[1] && p[1]<=ymax) return -1;
            }
            return (xmax-xmin) * (ymax-ymin);
        }
        public void backtrack(List<int[]> curr, int idx) {
            if (idx == n) {
                if (curr.size() == 4) {
                    int val = check(curr);
                    if (val!=-1) {
                        ans = Math.max(ans, val);
                    }
                }
                return;
            }

            backtrack(curr, idx+1);
            curr.add(points[idx]);
            backtrack(curr, idx+1);
            curr.remove(curr.size()-1);

        }
        public int maxRectangleArea(int[][] points) {
            n = points.length;
            this.points = points;
            backtrack(new ArrayList<>(), 0);
            return ans;
        }
    }
}
