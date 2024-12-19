# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    -
2. 시간복잡도 :
    O(    )
3. 자료구조 :
    -
import java.util.*;
class Solution {
    boolean[] visited = new boolean[100];
    List<Integer> boxCounts = new ArrayList<>();

    public void collectBoxes(int startIdx, int[] cards) {
        int count = 0;
        while (!visited[startIdx]) {
            visited[startIdx] = true;
            count++;
            startIdx = cards[startIdx]-1;
        }
        if (count!=0) boxCounts.add(count);
    }

    public int solution(int[] cards) {
        int ans = 0;
        for (int i=0; i<cards.length; i++) {
            if (!visited[i]) collectBoxes(i, cards);
        }

        Collections.sort(boxCounts, Collections.reverseOrder());
        if (boxCounts.size() >= 2) {
            ans = boxCounts.get(0) * boxCounts.get(1);
        }

        return ans;
    }
}
'''



