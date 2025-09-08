package Leetcode.java;

/*
1. 아이디어 :
2의 거듭제곱으로 나올 수 있는 모든 숫자들을 Set에 저장.
백트래킹으로 숫자를 재배열하면서 2의 거듭제곱인지 확인.

2. 시간복잡도 :
O( n! )

3. 자료구조/알고리즘 :
해시셋 / 백트래킹
 */

import java.util.HashSet;
import java.util.Set;

public class Q869 {
    class Solution {
        Set<Integer> powerOfTwo = new HashSet<>();
        String num;
        int length;
        boolean[] visited;
        boolean ans = false;

        public void backtrack(int size, int curr) {
            if (size == length) {
                ans = ans || powerOfTwo.contains(curr);
                return;
            }

            for (int i=0; i<length; i++) {
                if (visited[i]) continue;
                if (curr == 0 && num.charAt(i) == '0') continue;
                visited[i] = true;
                backtrack(size+1, curr*10 + num.charAt(i)-'0');
                visited[i] = false;
            }
        }

        public boolean reorderedPowerOf2(int n) {
            num = String.valueOf(n);
            length = num.length();
            visited = new boolean[length];

            int two = 1;
            while (two < 1_000_000_000) {
                powerOfTwo.add(two);
                two *=2;
            }

            backtrack(0, 0);
            return ans;
        }
    }
}
