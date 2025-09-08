package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashSet;
import java.util.Set;

public class Q3483 {
    class Solution {
        public int totalNumbers(int[] digits) {
            Set<Integer> candid = new HashSet<>();
            int n = digits.length;
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    for (int k=0; k<n; k++) {
                        if (i==j || j==k || k==i) continue;
                        if (digits[k] % 2 == 0 && digits[i] != 0) {
                            candid.add(digits[i]*100 + digits[j]*10 + digits[k]);
                        }
                    }
                }
            }
            return candid.size();
        }
    }

/*
class Solution {
    Set<Integer> candids = new HashSet<>();
    boolean[] visited;
    int[] digits;
    int n;
    public void backtrack(int curr, int idx) {
        if (curr >= 100 && curr < 1000) {
            if (curr % 2 == 0) candids.add(curr);
            return;
        }
        if (idx == n) return;

        backtrack(curr, idx+1);
        for (int i=0; i<n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            backtrack(curr * 10 + digits[i], idx+1);
            visited[i] = false;
        }
    }

    public int totalNumbers(int[] digits) {
        this.digits = digits;
        n = digits.length;
        visited = new boolean[n];
        backtrack(0, 0);
        return candids.size();
    }
}
*/
}
