package Leetcode;

public class Q793 {
    class Solution {

        public long getZeros2(long n) {
            long zeros = 0, div = 5;
            while (div <= n) {
                zeros += n/div;
                div *= 5;
            }
            return zeros;
        }

        public long binarysearch(int k) {
            long left = 0, right = 5L * (k+1);

            while (left < right) {
                long mid = left + (right - left) / 2;
                long zeros = getZeros2(mid);

                if (zeros < k) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }

        public int preimageSizeFZF(int k) {
            long left = binarysearch(k);
            return (getZeros2(left) != k) ? 0 : 5;
        }

    }
}
