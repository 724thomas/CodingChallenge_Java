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
    int maxPicks;
    Map<Integer, Integer> pickCount = new HashMap<>();
    List<List<Integer>> candid = new ArrayList<>();
    Map<String, Integer> mineralCost = new HashMap<>();
    String[] minerals;

    public int calcFatigue(List<Integer> comb) {
        int ans = 0;
        for (int i=0; i<comb.size(); i++) {
            int pick = comb.get(i);
            for (int j=i*5; j<Math.min(i*5+5, minerals.length); j++) {
                String mineral = minerals[j];
                int mcost = mineralCost.get(mineral);
                if (pick <= mcost) {
                    ans +=1;
                } else {
                    int diff = pick - mineralCost.get(mineral);
                    ans += Math.pow(5, diff);
                }
            }
        }
        return ans;
    }

    public void backtrack(List<Integer> comb, int count) {
        if (count == maxPicks) {
            candid.add(new ArrayList<>(comb));
            return;
        }
        for (int i=0; i<3; i++) {
            if (pickCount.get(i) == 0) continue;
            pickCount.put(i, pickCount.get(i)-1);
            comb.add(i);
            backtrack(comb, count+1);
            pickCount.put(i, pickCount.get(i)+1);
            comb.remove(comb.size()-1);
        }
    }

    public int solution(int[] picks, String[] minerals) {
        this.minerals = minerals;
        maxPicks = Math.min(picks[0]+picks[1]+picks[2], (int)Math.ceil((double)minerals.length/5));
        for (int i=0; i<3; i++) pickCount.put(i, picks[i]);
        mineralCost.put("diamond", 0);
        mineralCost.put("iron", 1);
        mineralCost.put("stone", 2);

        backtrack(new ArrayList<>(), 0);
        int ans = Integer.MAX_VALUE;
        for (List<Integer> comb: candid) {
            ans = Math.min(ans, calcFatigue(comb));
        }
        return ans;
    }
}
'''



