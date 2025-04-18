package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q777 {
    class Solution {
        public boolean canTransform(String start, String result) {
            int n = start.length();

            // [0/1: left/right, idx]
            List<int[]> startIdx = new ArrayList<>();
            List<int[]> resultIdx = new ArrayList<>();

            for (int i=0; i<n; i++) {
                if (start.charAt(i) == 'L') {
                    startIdx.add(new int[]{0, i});
                } else if (start.charAt(i) == 'R') {
                    startIdx.add(new int[]{1, i});
                }

                if (result.charAt(i) == 'L') {
                    resultIdx.add(new int[]{0, i});
                } else if (result.charAt(i) == 'R') {
                    resultIdx.add(new int[]{1, i});
                }
            }

            // for (var a : startIdx) System.out.print(Arrays.toString(a));
            // System.out.println();
            // for (var a : resultIdx) System.out.print(Arrays.toString(a));

            if (startIdx.size() != resultIdx.size()) return false;
            for (int i=0; i<startIdx.size(); i++) {
                if (startIdx.get(i)[0] != resultIdx.get(i)[0]) return false;

                if (startIdx.get(i)[0] == 0) { // left
                    if (startIdx.get(i)[1] < resultIdx.get(i)[1]) return false;
                } else if (startIdx.get(i)[0] == 1) { // right
                    if (startIdx.get(i)[1] > resultIdx.get(i)[1]) return false;
                }
            }
            return true;
        }
    }
}
