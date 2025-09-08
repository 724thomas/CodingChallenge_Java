package Leetcode.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1481 {
    class Solution {
        public int findLeastNumOfUniqueInts(int[] arr, int k) {
            int n = arr.length;
            Map<Integer, Integer> counter = new HashMap<>();
            for (int i=0; i<n; i++){
                int value = arr[i];
                counter.put(value, counter.getOrDefault(value, 0)+1);
            }
            List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(counter.entrySet());
            sortedEntries.sort(Map.Entry.comparingByValue());

            int total = 0;
            int removed = 0;
            for (Map.Entry<Integer, Integer> entry: sortedEntries){
                int count = entry.getValue();
                total ++;
                if (count <= k) {
                    k -= count;
                    removed ++;
                }
            }
            return total - removed;
        }
    }
}
