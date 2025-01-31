package Leetcode;

public class Q2409 {
    class Solution {
        int[] daysInMonth = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};

        public int serialize(String date) {
            String[] md = date.split("-");
            int day = Integer.parseInt(md[1]);

            for (int i=0; i<Integer.parseInt(md[0]); i++) {
                day += daysInMonth[i];
            }
            return day;
        }

        public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
            boolean[] alice = new boolean[366];
            for (int i=serialize(arriveAlice); i<=serialize(leaveAlice); i++) alice[i] = true;
            int ans = 0;
            for (int i=serialize(arriveBob); i<=serialize(leaveBob); i++) {
                if (alice[i]) ans++;
            }
            return ans;
        }
    }
}
