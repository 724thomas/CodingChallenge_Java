package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
update = O( 1 )
current = O( 1 )
maximum = O( log n )
minimum = O( log n )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q2034 {
    class Pair {
        int timestamp;
        int price;

        public Pair(int timestamp, int price) {
            this.timestamp = timestamp;
            this.price = price;
        }
    }
    class StockPrice {
        Map<Integer, Integer> timeToPrice = new HashMap<>();
        PriorityQueue<Pair> minPrice = new PriorityQueue<>((a, b) -> a.price - b.price);
        PriorityQueue<Pair> maxPrice = new PriorityQueue<>((a,b) -> b.price - a.price);
        int maxTime = 0;
        public StockPrice() {

        }

        public void update(int timestamp, int price) {
            timeToPrice.put(timestamp, price);
            Pair pair = new Pair(timestamp, price);
            minPrice.add(pair);
            maxPrice.add(pair);
            maxTime = Math.max(maxTime, timestamp);
        }

        public int current() {
            return timeToPrice.get(maxTime);
        }

        public int maximum() {
            while (maxPrice.peek().price != timeToPrice.get(maxPrice.peek().timestamp)) {
                maxPrice.poll();
            }
            return maxPrice.peek().price;
        }

        public int minimum() {
            while (minPrice.peek().price != timeToPrice.get(minPrice.peek().timestamp)) {
                minPrice.poll();
            }
            return minPrice.peek().price;
        }
    }

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
}
