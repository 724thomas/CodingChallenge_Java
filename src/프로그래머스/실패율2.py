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
    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        int players = stages.length;
        int fails = 0;
        
        ArrayList<double[]> sorting = new ArrayList<>();
        
        for (int curr = 1; curr <= N; curr++) {
            fails = 0;
            
            for (int i = 0; i < stages.length; i++) {
                if (stages[i] == curr) {
                    fails++;
                }
            }
            if (players > 0) {
                sorting.add(new double[]{curr, (double) fails / players});
            } else {
                sorting.add(new double[]{curr, 0.0});
            }
            players -= fails;
        }
        
        sorting.sort((a, b) -> {
            if (b[1] == a[1]) {
                return Double.compare(a[0], b[0]);
            } else {
                return Double.compare(b[1], a[1]);
            }
        });
        
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = (int) sorting.get(i)[0];
        }
        
        return result;
    }
}'''

