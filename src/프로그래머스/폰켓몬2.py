# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int n = nums.length/2;
        Set<Integer> kinds = new HashSet<>();
        for (int num:nums){
            kinds.add(num);
        }
        return Math.min(n, kinds.size());
    }
}

'''


