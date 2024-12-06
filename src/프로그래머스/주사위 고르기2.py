# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    백트래킹을 통해 주사위 조합을 구합니다.
    A와 B가 가지는 주사위를 나누고, A와 B의 각 주사위 눈을 저장합니다.
    백트래킹을 통해, A와 B각각의 주사위 눈들의 합을 해시맵에 저장합니다.
    A와 B 해시맵을 통해서 값을 비교해서 이기는 수가 가장 많은 조합을 리턴합니다.
2. 시간복잡도 :
    O( 2**n )
3. 자료구조 :
    해시맵, 해시셋, 배열

import java.util.*;

public class Solution {
    public List<List<Integer>> getComb(int n, int r) {
        List<List<Integer>> combinations = new ArrayList<>();
        getCombDFS(n, r, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    public void getCombDFS(int n, int r, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == r) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < n; i++) {
            current.add(i);
            getCombDFS(n, r, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public Map<Integer, Integer> calcSum(List<int[]> diceGroup) {
        Map<Integer, Integer> sums = new HashMap<>();
        calcSumDFS(diceGroup, 0, 0, sums);
        return sums;
    }

    public void calcSumDFS(List<int[]> diceGroup, int index, int curr, Map<Integer, Integer> sums) {
        if (index == diceGroup.size()) {
            sums.put(curr, sums.getOrDefault(curr, 0) + 1);
            return;
        }
        for (int value : diceGroup.get(index)) {
            calcSumDFS(diceGroup, index + 1, curr + value, sums);
        }
    }

    public int calcWin(List<int[]> groupA, List<int[]> groupB) {
        Map<Integer, Integer> candidsA = calcSum(groupA);
        Map<Integer, Integer> candidsB = calcSum(groupB);

        int winA = 0;
        for (var entryA : candidsA.entrySet()) for (var entryB : candidsB.entrySet()) {
            if (entryA.getKey() > entryB.getKey()) {
                winA += entryA.getValue() * entryB.getValue();
            }
        }
        return winA;
    }

    public List<Integer> solution(int[][] dice) {
        int n = dice.length;
        int maxDices = n / 2;

        List<List<Integer>> combinations = getComb(n, maxDices);
        int cmax = -1;
        List<Integer> ans = null;

        for (List<Integer> combA : combinations) {
            Set<Integer> combASet = new HashSet<>(combA);
            List<Integer> combB = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!combASet.contains(i)) {
                    combB.add(i);
                }
            }

            List<int[]> dicesA = new ArrayList<>();
            List<int[]> dicesB = new ArrayList<>();

            for (int i : combA) dicesA.add(dice[i]);
            for (int i : combB) dicesB.add(dice[i]);

            int winA = calcWin(dicesA, dicesB);

            if (winA > cmax) {
                cmax = winA;
                ans = combA;
            }
        }

        List<Integer> ans2 = new ArrayList<>();
        for (int idx : ans) ans2.add(idx + 1);
        Collections.sort(ans2);
        return ans2;
    }
}

'''



