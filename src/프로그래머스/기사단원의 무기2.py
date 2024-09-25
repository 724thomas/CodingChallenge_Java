'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public int get_power(int n, int limit, int power){
        if (n==1) return 1;
        int count = 0;
        for (int i=1; i<=Math.sqrt(n); i++){
            if (n % i == 0){
                count += (i * i == n) ? 1 : 2;
            }
            if (count > limit){
                return power;
            }
        }
        return count;
    }
    public int solution(int number, int limit, int power) {
        int ans = 0;
        for (int i=1; i<=number; i++) {
            ans += get_power(i, limit, power);
        }
        return ans;
    }
}



'''


