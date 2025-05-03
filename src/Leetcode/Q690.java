package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q690 {

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};


    class Solution {
        public int getImportance(List<Employee> employees, int id) {
            Map<Integer, Employee> map = new HashMap<>();
            for (Employee e : employees) {
                map.put(e.id, e);
            }

            int ans = 0;
            Deque<Employee> deque = new ArrayDeque<>();
            deque.add(map.get(id));

            while (!deque.isEmpty()) {
                Employee curr = deque.poll();
                ans += curr.importance;
                for (Integer sub : curr.subordinates) {
                    deque.add(map.get(sub));
                }
            }
            return ans;
        }
    }
}
