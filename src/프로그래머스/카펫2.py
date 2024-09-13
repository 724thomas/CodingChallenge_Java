# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    static ArrayList<int[]> getPair(int n){
        var ans = new ArrayList<int[]>();
        for (int i=1; i<=n/2; i++){
            if (n%i == 0 && i+2 <= n/i+2){
                ans.add(new int[]{n/i+2, i+2});
            }
        }
        return ans;
    }
    public int[] solution(int brown, int yellow) {
        if (yellow == 1) return new int[]{3,3};
        for (int[] cords: getPair(yellow)){
            if (cords[0] * 2 + (cords[1]-2) *2 == brown){
                return new int[]{cords[0], cords[1]};
            }
        }
        return new int[]{};
    }
}'''