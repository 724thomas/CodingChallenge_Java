package Leetcode;

public class Q1533 {
    /**
     * // This is ArrayReader's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface ArrayReader {
     *     // Compares the sum of arr[l..r] with the sum of arr[x..y]
     *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
     *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
     *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
     *     public int compareSub(int l, int r, int x, int y) {}
     *
     *     // Returns the length of the array
     *     public int length() {}
     * }
     */
/*
    class Solution {
        public int getIndex(ArrayReader reader) {
            int n = reader.length();
            int left = 0, right = n-1;

            while (left<right) {
                int size = (right - left + 1);
                int mid = left + (size/2);

                if (size%2==0) {
                    int result = reader.compareSub(left, mid-1, mid, right);
                    if (result == 1) {
                        right = mid-1;
                    } else {
                        left = mid;
                    }
                } else {
                    int result = reader.compareSub(left, mid-1, mid+1, right);
                    if (result==1) {
                        right = mid-1;
                    } else if (result==-1) {
                        left = mid+1;
                    } else {
                        return mid;
                    }
                }
            }
            return left;
        }
    }

 */
}
