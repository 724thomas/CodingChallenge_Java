'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public int lcm(int a, int b){
        if (a==b) return a;
        Set<Integer> candid= new HashSet<>();
        for (int i=1; i<=b; i++) {
            candid.add(a*i);
        }
        for (int i=1; i<=a; i++) {
            if (candid.contains(b*i)) {
                return b*i;
            }
        }
        return -1;
    }

    public int solution(int[] arr) {
        int base = arr[0];
        for (int i=1; i<arr.length; i++){
            base = lcm(base, arr[i]);
        }
        return base;
    }
}



'''


