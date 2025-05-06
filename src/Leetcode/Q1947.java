package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1947 {
    class Solution {
        int n, m, q;
        int ans = 0;
        int[][] students, mentors;

        public int getScore(int[] student, int[] mentor) {
            int ans = 0;
            for (int i=0; i<q; i++) {
                if (student[i] == mentor[i]) ans++;
            }
            return ans;
        }

        public void backtrack(int sIdx, boolean[] mVisited, int total) {
            if (sIdx == n) {
                ans = Math.max(ans, total);
                return;
            }

            for (int i=0; i<m; i++) {
                if (mVisited[i]) continue;

                mVisited[i] = true;

                int score = getScore(students[sIdx], mentors[i]);
                backtrack(sIdx+1, mVisited, total + score);

                mVisited[i] = false;
            }

        }
        public int maxCompatibilitySum(int[][] students, int[][] mentors) {
            n = students.length;
            m = mentors.length;
            q = students[0].length;
            this.students = students;
            this.mentors = mentors;
            backtrack(0, new boolean[m], 0);

            return ans;
        }
    }
}
