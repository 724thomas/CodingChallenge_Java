package Leetcode;

import java.util.Arrays;

public class Q1566 {
    class Solution {

        public boolean containsPattern(int[] arr, int m, int k) {
            for(int i=0; i<arr.length-m; i++) {
                int[] curr = Arrays.copyOfRange(arr, i, i+m);
                int counter = 1;

                for(int j=i+m; j<arr.length; j+=m) {
                    int[] next = Arrays.copyOfRange(arr, j, j+m);
                    if(Arrays.equals(curr, next)) counter++; else break;
                    if(counter == k) return true;
                }
            }

            return false;
        }
    }
}
