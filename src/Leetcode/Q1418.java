package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q1418 {
    class Solution {
        public List<List<String>> displayTable(List<List<String>> orders) {
            Set<String> columnNames = new TreeSet<>();
            Set<Integer> tables = new TreeSet<>();
            Map<Integer, Map<String, Integer>> totalOrders = new HashMap<>();// table : food : amount


            for (List<String> order : orders) {
                int table = Integer.parseInt(order.get(1));
                String food = order.get(2);

                //add column, table
                columnNames.add(food);
                tables.add(table);

                //fill map
                totalOrders.putIfAbsent(table, new HashMap<>());
                Map<String, Integer> foodOrders = totalOrders.get(table);
                foodOrders.put(food, foodOrders.getOrDefault(food, 0)+1);
            }

            List<List<String>> ans = new ArrayList<>();

            //top row
            List<String> columns = new ArrayList<>(List.of("Table"));
            for (String columnName : columnNames) columns.add(columnName);

            ans.add(columns);

            for (Integer table : tables) {
                List<String> tableAns = new ArrayList<>(List.of(String.valueOf(table)));
                for (String food : columnNames) {
                    tableAns.add(String.valueOf(totalOrders.get(table).getOrDefault(food, 0)));
                }
                ans.add(tableAns);
            }

            return ans;
        }
    }
}
