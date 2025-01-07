package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q3414 {

    public class Solution {
        public int[] maximumWeight(List<List<Integer>> intervals) {
            int n = intervals.size(), K = 4;

            int[][] arr = new int[n][4];
            for (int i = 0; i < n; i++) {
                List<Integer> interval = intervals.get(i);
                arr[i][0] = interval.get(0);
                arr[i][1] = interval.get(1);
                arr[i][2] = interval.get(2);
                arr[i][3] = i;
            }
            Arrays.sort(arr, (a, b) -> a[1] - b[1]);

            // binarysearch 겹치지 않는 마지막 구간 idx
            int[] p = new int[n];
            Arrays.fill(p, -1);
            for (int i = 0; i < n; i++) {
                int startI = arr[i][0];
                int low = 0, high = i - 1;
                int ans = -1;
                while (low <= high) {
                    int mid = (low + high) >>> 1;
                    if (arr[mid][1] < startI) {
                        ans = mid;
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                p[i] = ans;
            }

            // for (var a : arr) System.out.println(Arrays.toString(a));
            // System.out.println(Arrays.toString(p));

            long[][] dpScores = new long[n+1][K+1];

            ArrayList<Integer>[][] dpIndices = new ArrayList[n+1][K+1];
            for (int i = 0; i <= n; i++) {
                for (int k = 0; k <= K; k++) {
                    dpScores[i][k] = 0L;
                    dpIndices[i][k] = new ArrayList<>();
                }
            }

            for (int i = 1; i <= n; i++) {
                for (int kk = 1; kk <= K; kk++) {

                    // skip
                    dpScores[i][kk] = dpScores[i-1][kk];
                    dpIndices[i][kk] = new ArrayList<>(dpIndices[i-1][kk]);

                    // include
                    long w = arr[i-1][2];
                    int pi = p[i-1];
                    long prevScore = (pi == -1) ? 0 : dpScores[pi+1][kk-1];
                    long candScore = w + prevScore;

                    ArrayList<Integer> candIndices = new ArrayList<>();
                    if (pi != -1) {
                        candIndices = new ArrayList<>(dpIndices[pi+1][kk-1]);
                    }
                    candIndices.add(arr[i-1][3]);


                    if (candScore > dpScores[i][kk]) { // value 비교
                        dpScores[i][kk] = candScore;
                        dpIndices[i][kk] = candIndices;

                    } else if (candScore == dpScores[i][kk]) { // lexicographical 비교
                        ArrayList<Integer> oldList = dpIndices[i][kk];
                        if (isLexiSmaller(candIndices, oldList)) {
                            dpIndices[i][kk] = candIndices;
                        }
                    }
                }
            }

            ArrayList<Integer> ansList = dpIndices[n][K];
            Collections.sort(ansList);

            int[] answer = new int[ansList.size()];
            for (int i = 0; i < ansList.size(); i++) answer[i] = ansList.get(i);
            return answer;
        }

        public boolean isLexiSmaller(List<Integer> a, List<Integer> b) {
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                if (!a.get(i).equals(b.get(i))) return a.get(i) < b.get(i);
            }
            return a.size() < b.size();
        }
    }

}
