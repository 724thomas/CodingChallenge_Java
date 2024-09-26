'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public String solution(int a, int b) {
        //1:31 2:29 3:31 4:30 5:31 6:30 7:31 8:31 9:30 10:31 11:30 12:31
        Map<Integer, Integer> days = new HashMap<>();
        days.put(1,31);
        days.put(2,29);
        days.put(3,31);
        days.put(4,30);
        days.put(5,31);
        days.put(6,30);
        days.put(7,31);
        days.put(8,31);
        days.put(9,30);
        days.put(10,31);
        days.put(11,30);
        ArrayList<String> weekdays = new ArrayList<>();
        weekdays.add("THU");
        weekdays.add("FRI");
        weekdays.add("SAT");
        weekdays.add("SUN");
        weekdays.add("MON");
        weekdays.add("TUE");
        weekdays.add("WED");

        int startDay = 0;
        for (int i=1; i<a; i++) startDay += days.get(i);
        return weekdays.get((startDay+b)%7);
    }
}



'''


