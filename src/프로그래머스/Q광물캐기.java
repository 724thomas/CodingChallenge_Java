package 프로그래머스;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q광물캐기 {

    class Solution {
        int maxPicks;
        Map<String, Integer> mineralCost = new HashMap<>();
        String[] minerals;
        int[] picks;

        public int solution(int[] picks, String[] minerals) {
            this.minerals = minerals;
            this.picks = picks;

            // 광물 중요도를 숫자로 매핑
            mineralCost.put("diamond", 0);
            mineralCost.put("iron", 1);
            mineralCost.put("stone", 2);

            // 사용할 곡괭이 개수 제한
            maxPicks = Math.min(picks[0] + picks[1] + picks[2], (int) Math.ceil((double) minerals.length / 5));

            // 광물 그룹화 (5개씩)
            List<int[]> mineralGroups = groupMinerals();

            // 중요도가 높은 그룹부터 정렬
            mineralGroups.sort((a, b) -> b[0] - a[0]);

            // 피로도 계산
            return calculateFatigue(mineralGroups);
        }

        private List<int[]> groupMinerals() {
            List<int[]> groups = new ArrayList<>();
            for (int i = 0; i < minerals.length; i += 5) {
                int[] group = new int[3]; // 다이아, 철, 돌 개수
                for (int j = i; j < i + 5 && j < minerals.length; j++) {
                    int cost = mineralCost.get(minerals[j]);
                    group[cost]++;
                }
                groups.add(group);
            }
            return groups;
        }

        private int calculateFatigue(List<int[]> mineralGroups) {
            int fatigue = 0;

            for (int[] group : mineralGroups) {
                if (maxPicks == 0) break;

                // 우선순위: 다이아 > 철 > 돌
                if (picks[0] > 0) { // 다이아 곡괭이
                    fatigue += group[0] + group[1] + group[2];
                    picks[0]--;
                } else if (picks[1] > 0) { // 철 곡괭이
                    fatigue += group[0] * 5 + group[1] + group[2];
                    picks[1]--;
                } else if (picks[2] > 0) { // 돌 곡괭이
                    fatigue += group[0] * 25 + group[1] * 5 + group[2];
                    picks[2]--;
                }
                maxPicks--;
            }

            return fatigue;
        }
    }

}
