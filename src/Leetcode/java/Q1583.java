package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q1583 {
    class Solution {
        public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
            int m = pairs.length;
            Map<Integer, Map<Integer, Integer>> prefs = new HashMap<>();
            for (int i=0; i<n; i++) {
                Map<Integer, Integer> pref = new HashMap<>();
                for (int j=0; j<n-1; j++) {
                    pref.put(preferences[i][j], j);
                }
                prefs.put(i, pref);
            }

            Set<Integer> unhappy = new HashSet<>();
            for (int i=0; i<m; i++) {
                int[] pair1 = pairs[i];

                for (int j=i+1; j<m; j++) {
                    int[] pair2 = pairs[j];

                    int x = pair1[0], y = pair1[1];
                    int u = pair2[0], v = pair2[1];

                    if (!unhappy.contains(x) && prefs.get(x).get(u) < prefs.get(x).get(y)
                            && prefs.get(u).get(x) < prefs.get(u).get(v)) {
                        unhappy.add(x);
                    }

                    if (!unhappy.contains(x) && prefs.get(x).get(v) < prefs.get(x).get(y)
                            && prefs.get(v).get(x) < prefs.get(v).get(u)) {
                        unhappy.add(x);
                    }

                    if (!unhappy.contains(y) &&prefs.get(y).get(u) < prefs.get(y).get(x)
                            && prefs.get(u).get(y) < prefs.get(u).get(v)) {
                        unhappy.add(y);
                    }

                    if (!unhappy.contains(y) && prefs.get(y).get(v) < prefs.get(y).get(x)
                            && prefs.get(v).get(y) < prefs.get(v).get(u)) {
                        unhappy.add(y);
                    }


                    if (!unhappy.contains(u) && prefs.get(u).get(x) < prefs.get(u).get(v)
                            && prefs.get(x).get(u) < prefs.get(x).get(y)) {
                        unhappy.add(u);
                    }

                    if (!unhappy.contains(u) && prefs.get(u).get(y) < prefs.get(u).get(v)
                            && prefs.get(y).get(u) < prefs.get(y).get(x)) {
                        unhappy.add(u);
                    }

                    if (!unhappy.contains(v) && prefs.get(v).get(x) < prefs.get(v).get(u)
                            && prefs.get(x).get(v) < prefs.get(x).get(y)) {
                        unhappy.add(v);
                    }

                    if (!unhappy.contains(v) && prefs.get(v).get(y) < prefs.get(v).get(u)
                            && prefs.get(y).get(v) < prefs.get(y).get(x)) {
                        unhappy.add(v);
                    }
                }
            }
            return unhappy.size();
        }
    }
}
