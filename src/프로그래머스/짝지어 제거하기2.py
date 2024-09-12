# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''

'''
import java.util.*;
class Solution {
    public int solution(int n) {
        boolean[] sieve = new boolean[n+1];
        int start = 2;

        int m = (int) Math.sqrt(n+1);
        for (int i = 2; i <= m; i++) {
            if (!sieve[i]) {
                for (int j = i + i; j < n+1; j += i) {
                    sieve[j] = true;
                }
            }
        }
        int count = 0;
        for (int i = start; i < n+1; i++) {
            if (!sieve[i]) count++;
        }
        return count;
    }
}'''