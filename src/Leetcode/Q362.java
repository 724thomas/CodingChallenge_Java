package Leetcode;

public class Q362 {
    class HitCounter {
        private int[] times;
        private int[] hits;

        public HitCounter() {
            times = new int[300];
            hits = new int[300];
        }

        public void hit(int timestamp) {
            int index = timestamp % 300;
            if (times[index] != timestamp) {
                times[index] = timestamp;
                hits[index] = 1;
            } else {
                hits[index]++;
            }
        }

        public int getHits(int timestamp) {
            int totalHits = 0;
            for (int i = 0; i < 300; i++) {
                if (timestamp - times[i] < 300) {
                    totalHits += hits[i];
                }
            }
            return totalHits;
        }
    }

}
