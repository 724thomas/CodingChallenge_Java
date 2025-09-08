package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Q1244 {
    class Leaderboard {
        Map<Integer, Integer> playerScores;
        TreeSet<int[]> sortedScores = new TreeSet<>((a,b)->b[1]-a[1]);

        public Leaderboard() {
            playerScores = new HashMap<>();
            sortedScores = new TreeSet<>((a, b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);
        }

        public void addScore(int playerId, int score) {
            if (playerScores.containsKey(playerId)) {
                sortedScores.remove(new int[]{playerId, playerScores.get(playerId)});
                playerScores.put(playerId, playerScores.get(playerId) + score);
            } else {
                playerScores.put(playerId, score);
            }
            sortedScores.add(new int[]{playerId, playerScores.get(playerId)});
        }

        public int top(int K) {
            int sum = 0;
            int count = 0;
            for (int[] entry : sortedScores) {
                sum += entry[1];
                count++;
                if (count == K) break;
            }
            return sum;
        }

        public void reset(int playerId) {
            sortedScores.remove(new int[]{playerId, playerScores.get(playerId)});
            playerScores.remove(playerId);
        }
    }

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
}
