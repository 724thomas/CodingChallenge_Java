package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q729 {
    class MyCalendar {

        List<int[]> ranges; // start, end
        public MyCalendar() {
            ranges = new ArrayList<>();
        }

        public boolean book(int startTime, int endTime) { // 1000 call
            endTime--;
            for (int[] range : ranges) {
                if (range[1] < startTime || endTime < range[0]) continue;
                return false;
            }
            ranges.add(new int[]{startTime, endTime});
            return true;
        }
    }

/*
class MyCalendar {
    int start = 0, end = 1_000_000_000;
    Map<Long, Boolean> tree;

    public MyCalendar() {
        tree = new HashMap<>();
    }

    public boolean book(int startTime, int endTime) {
        endTime--;
        if (!query(0, start, end, startTime, endTime)) {
            update(0, start, end, startTime, endTime) ;
            return true;
        }
        return false;
    }

    private boolean query(long node, int left, int right, int qleft, int qright) {
        if (qright < left || right < qleft) return false;
        if (tree.getOrDefault(node, false)) return true;
        if (left == right) return false;

        int mid = left + (right - left)/2;
        return query( 2* node+1, left, mid, qleft, qright)
            || query( 2*node+2, mid+1, right, qleft, qright);
    }

    private void update(long node, int left, int right, int qleft, int qright) {
        if (qright < left || right < qleft) return;
        if (qleft <= left && right <= qright) {
            tree.put(node, true);
            return;
        }

        int mid = left + (right-left)/2;
        update(2 * node+1, left, mid, qleft, qright);
        update(2 * node+2, mid+1, right, qleft, qright);

        boolean leftAvailable = tree.getOrDefault(2 * node+1, false);
        boolean rightAvailable = tree.getOrDefault(2 * node+2, false);
        tree.put(node, leftAvailable && rightAvailable);
    }
}

*/

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */
}
