package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.PriorityQueue;

public class Q1705 {
    class Apple {
        int quantity;
        int rotDay;

        public Apple(int quantity, int rotDay) {
            this.quantity = quantity;
            this.rotDay = rotDay;
        }
    }
    class Solution {
        public int eatenApples(int[] apples, int[] days) {
            int n = apples.length;
            PriorityQueue<Apple> grown = new PriorityQueue<>((a, b) -> a.rotDay-b.rotDay);

            int day = 0, ans = 0;
            while (day < n || !grown.isEmpty()) {
                if (day < n) grown.add(new Apple(apples[day], day + days[day]));

                while (!grown.isEmpty() && (grown.peek().rotDay <= day || grown.peek().quantity == 0)) {
                    grown.poll();
                }

                if (!grown.isEmpty()) {
                    grown.peek().quantity--;
                    ans++;
                }
                day++;
            }

            return ans;
        }
    }
}
