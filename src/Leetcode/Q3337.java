package Leetcode;

/*
1. 아이디어 :
해시맵(prev)으로 count를 한 후에, 새로운 해시맵(curr)에 연산 결과를 저장합니다.
위 작업을 t번 반복하는데, 시간초과.

2차원 배열을 통해서 규칙을 만듭니다. m[j][i]=1 는 i번쨰 알파벳을 변환했을때 j가 된다는 뜻입니다.
위 배열을 t번 O(logn) 시간복잡도로 곱합니다.(m^10 이면, m^4 * m^4 * m^2로 나눌 수 있습니다)
마지막 결과에 s에 있는 char 갯수만큼 곱합니다.

2. 시간복잡도 :
O( 26*26 * logt )

3. 자료구조/알고리즘 :
배열 / -
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q3337 {
    class Solution {
        int MOD = 1_000_000_007;
        Map<Integer, long[][]> memo = new HashMap<>();

        public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
            int n = 26;
            long[][] m = new long[n][n];

            for (int i = 0; i < n; i++) for (int j = 1; j <= nums.get(i); j++) {
                m[(i + j) % n][i] = 1;
            }

            long[][] mt = matrixPower(m, t); // m^t

            long[] counter = new long[n];
            for (char c : s.toCharArray()) counter[c - 'a']++;

            long[] finalVec = multiplyMatrixVector(mt, counter);

            long total = 0;
            for (long count : finalVec) total = (total + count) % MOD;
            return (int) total;
        }

        public long[][] matrixPower(long[][] m, int power) {
            if (power == 1) return m;
            if (memo.containsKey(power)) return memo.get(power);

            long[][] ans;
            if (power % 2 == 0) { // power가 짝수인 경우: m^power = (m^(power/2)) × (m^(power/2))
                long[][] half = matrixPower(m, power / 2);
                ans = multiplyMatrix(half, half);
            } else {  // power가 홀수인 경우: m^power = (m^((power-1)/2))² × m
                long[][] half = matrixPower(m, (power - 1) / 2);
                ans = multiplyMatrix( multiplyMatrix(half, half), m );
            }
            memo.put(power, ans);
            return ans;
        }

        public long[][] multiplyMatrix(long[][] mat1, long[][] mat2) {
            int n = mat1.length;
            long[][] ans = new long[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    long sum = 0;
                    for (int k = 0; k < n; k++) {
                        sum = (sum + mat1[i][k] * mat2[k][j]) % MOD;
                    }
                    ans[i][j] = sum;
                }
            }
            return ans;
        }

        public long[] multiplyMatrixVector(long[][] m, long[] v) {
            int n = v.length;
            long[] res = new long[n];
            for (int i = 0; i < n; i++) {
                long sum = 0;
                for (int j = 0; j < n; j++) {
                    sum = (sum + m[i][j] * v[j]) % MOD;
                }
                res[i] = sum;
            }
            return res;
        }
    }



/*
class Solution {
    List<Integer> nums;
    int MOD = 1_000_000_007;

    public int[] getNext(int idx, int rep) {
        int[] counter = new int[26];
        char c = (char)(idx + 'a');
        int num = nums.get((c - 'a'));
        for (int i=0; i<num; i++) {
            counter[(c-'a'+1)%26] = (counter[(c-'a'+1)%26] + rep) % MOD;
            c = (char) (c+1);
        }
        return counter;
    }

    public int[] combine(int[] l1, int[] l2) {
        for (int i=0; i<26; i++) l1[i] = (l1[i]+l2[i]) % MOD;
        return l1;
    }

    public int[] dfs(int[] prev) {
        int[] curr = new int[26];
        for (int i=0; i<26; i++) {
            if (prev[i] == 0) continue;
            combine(curr, getNext(i, prev[i]));
        }
        return curr;
    }

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        this.nums = nums;
        int n = s.length();

        int[] prev = new int[26];
        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            prev[c-'a']++;
        }

        for (int i=0; i<t; i++) {
            prev = dfs(prev);
        }

        int ans = 0;
        for (int i=0; i<26; i++) ans=(ans+prev[i])%MOD;
        return ans;
    }
}
*/
}
