package Leetcode.java;

public class Q990 {
    class Solution {
        int[] par;
        int[] rank;

        public int find(int x) {
            if (x != par[x]) {
                par[x] = find(par[x]);
            }
            return par[x];
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA != rootB) {
                if (rank[rootA] > rank[rootB]) {
                    par[rootB] = rootA;
                } else if (rank[rootA] < rank[rootB]) {
                    par[rootA] = rootB;
                } else {
                    par[rootB] = rootA;
                    rank[rootA]++;
                }
            }
        }

        public boolean equationsPossible(String[] equations) {
            par = new int[26];
            rank = new int[26];

            for (int i = 0; i < 26; i++) {
                par[i] = i;
                rank[i] = 0;
            }

            for (String equation : equations) {
                if (equation.charAt(1) == '=') {
                    int a = equation.charAt(0) - 'a';
                    int b = equation.charAt(3) - 'a';
                    union(a, b);
                }
            }

            for (String equation : equations) {
                if (equation.charAt(1) == '!') {
                    int a = equation.charAt(0) - 'a';
                    int b = equation.charAt(3) - 'a';
                    if (find(a) == find(b)) {
                        return false;
                    }
                }
            }

            return true;
        }
    }

}
