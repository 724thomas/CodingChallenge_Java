package Leetcode;

/*
1. 아이디어 :
event1의 끝 < event2의 시작 또는
event2의 끝 < event1의 시작 이면 두 이벤트는 겹치지 않는다.

2. 시간복잡도 :
O( 1 )

3. 자료구조/알고리즘 :
배열 / -
 */

public class Q2446 {
    class Solution {
        public int[] toTimes(String[] event) {
            int[] times = new int[2];
            String[] start = event[0].split(":");
            times[0] = Integer.parseInt(start[0]+start[1]);
            String[] end = event[1].split(":");
            times[1] = Integer.parseInt(end[0] + end[1]);
            return times;
        }
        public boolean haveConflict(String[] event1, String[] event2) {
            int[] times1 = toTimes(event1);
            int[] times2 = toTimes(event2);
            if (times1[1] < times2[0]) return false;
            if (times2[1] < times1[0]) return false;
            return true;

        }
    }
}
