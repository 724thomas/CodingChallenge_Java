package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q1396 {
    class UndergroundSystem {
        Map<String, Double> totalTime;
        Map<String, Integer> passengersCount;
        Map<Integer, Integer> startTimes;
        Map<Integer, String> startStations;

        public UndergroundSystem() {
            totalTime = new HashMap<>();
            passengersCount = new HashMap<>();
            startTimes = new HashMap<>();
            startStations = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            startStations.put(id, stationName);
            startTimes.put(id, t);
        }

        public void checkOut(int id, String stationName, int t) {
            String startStation = startStations.get(id);
            int startTime = startTimes.get(id);

            String key = startStation + "-" + stationName;
            if (!passengersCount.containsKey(key)) {
                passengersCount.put(key, 0);
                totalTime.put(key, 0.0);
            }
            passengersCount.put(key, passengersCount.get(key) + 1);
            totalTime.put(key, totalTime.get(key) + t - startTime);
        }

        public double getAverageTime(String startStation, String endStation) {
            String key = startStation + "-" + endStation;
            return totalTime.get(key) / passengersCount.get(key);
        }
    }

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
}
