# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        int initCards = n / 3;

        Set<Integer> playerCards = new HashSet<>();
        for (int i = 0; i < initCards; i++) playerCards.add(cards[i]);

        Deque<Integer> deck = new ArrayDeque<>();
        for (int i = initCards; i < n; i++) deck.add(cards[i]);

        Set<Integer> candidCards = new HashSet<>();
        int round = 1;

        while (!deck.isEmpty()) {
            if (deck.size() < 2) break;

            int target = n + 1;
            boolean found = false;

            candidCards.add(deck.poll());
            candidCards.add(deck.poll());

            // 0 coin
            for (int card : playerCards) {
                if (playerCards.contains(target - card) && card != target - card) {
                    playerCards.remove(card);
                    playerCards.remove(target - card);
                    found = true;
                    break;
                }
            }

            // 1 coin
            if (!found && coin >= 1) {
                for (int candidCard : new ArrayList<>(candidCards)) {
                    if (playerCards.contains(target - candidCard)) {
                        coin--;
                        playerCards.remove(target - candidCard);
                        playerCards.add(candidCard);
                        candidCards.remove(candidCard);
                        found = true;
                        break;
                    }
                }
            }

            // 2 coins
            if (!found && coin >= 2) {
                for (int candidCard : new ArrayList<>(candidCards)) {
                    if (candidCards.contains(target - candidCard) && candidCard != target - candidCard) {
                        coin -= 2;
                        candidCards.remove(candidCard);
                        candidCards.remove(target - candidCard);
                        found = true;
                        break;
                    }
                }
            }

            if (!found) return round;
            round++;
        }

        return round;
    }
}

'''



