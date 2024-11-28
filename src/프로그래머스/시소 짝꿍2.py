# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    투포인터로 풀 수 있습니다.
    weight가 100,000이라서 n**2으로 하면 시간초과.
    해시셋으로 n을 최대 901로 만들어 놓고 n**2

2. 시간복잡도 :
    O( 901**901 )
3. 자료구조 :
    해시맵, 배열

import java.util.*;
class Solution {
    public boolean match(int a, int b) {
        for (int d1=2; d1<=4; d1++) {
            for (int d2=2; d2<=4; d2++) {
                if (a*d1 == b*d2) return true;
            }
        }
        return false;
    }

    public long solution(int[] weights) {
        Map<Integer, Integer> wCounts = new HashMap<>();
        for (int weight : weights) wCounts.put(weight, wCounts.getOrDefault(weight,0)+1);

        List<Integer> uWeights = new ArrayList<>(wCounts.keySet());
        Collections.sort(uWeights);

        long ans = 0;
        int N = uWeights.size();

        for (int i=0; i<N; i++) {
            int w1 = uWeights.get(i);
            int w1Count = wCounts.get(w1);

            if (w1Count > 1) ans += (long)w1Count * (w1Count-1) / 2;

            for (int j=i+1; j<N; j++) {
                int w2 = uWeights.get(j);
                int w2Count = wCounts.get(w2);
                if (match(w1, w2)) {
                    ans += (long)w1Count * w2Count;
                }
            }
        }
        return ans;
    }
}
'''



