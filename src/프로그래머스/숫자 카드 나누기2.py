# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    ArrayA를 만족하는 최대 공약수를 구합니다.
    최대 공약수의 약수들을 구합니다.
    각 약수를 ArrayB 원소들과 비교하면서 나눌 수 있는지 확인합니다.
2. 시간복잡도 :
    O( nlogm)
3. 자료구조 :
    배열

import java.util.*;
class Solution {
    public int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b, a%b);
    }

    public int gcdFromArray(int[] array) {
        int ans = array[0];
        for (int i = 1; i < array.length; i++) ans = gcd(ans, array[i]);
        return ans;
    }

    public List<Integer> gcdDivisors(int gcd) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= gcd; i++) if (gcd % i == 0) divisors.add(i);
        Collections.sort(divisors, Collections.reverseOrder());
        return divisors;
    }

    public boolean check(int gcd, int[] array) {
        for (int n : array) {
            if (n % gcd == 0) return false;
        }
        return true;
    }


    public int solution(int[] arrayA, int[] arrayB) {
        int ans = 0;
        List<Integer> candidA = gcdDivisors(gcdFromArray(arrayA));
        for (int gcd : candidA) if (check(gcd, arrayB)) ans = Math.max(ans, gcd);

        List<Integer> candidB = gcdDivisors(gcdFromArray(arrayB));
        for (int gcd : candidB) if (check(gcd, arrayA)) ans = Math.max(ans, gcd);
        return ans;
    }
}
'''



