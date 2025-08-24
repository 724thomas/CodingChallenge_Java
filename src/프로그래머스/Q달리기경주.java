package 프로그래머스;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q달리기경주 {

    class Solution {
        public String[] solution(String[] players, String[] callings) {
            int n = players.length;
            Map<String, Integer> map = new HashMap<>();
            String[] rank = new String[n];

            for (int i=0; i<n; i++) {
                map.put(players[i], i);
                rank[i] = players[i];
            }

            for (String backName : callings) {
                int backRank = map.get(backName);
                String frontName = rank[backRank-1];
                map.put(frontName, backRank);
                map.put(backName, backRank-1);
                rank[backRank] = frontName;
                rank[backRank-1] = backName;
            }
            return rank;
        }
    }
}
