package Leetcode;

public class Q484 {
    class Solution {
        public void reverse(int[] arr, int start, int end) {
            while (start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start ++;
                end --;
            }
        }

        public int[] findPermutation(String s) {
            int n = s.length();
            int[] perm = new int[n+1];

            for (int i=0; i<=n; i++) {
                perm[i] = i+1;
            }
            // System.out.println(Arrays.toString(perm));

            for (int i=0; i<n; i++) {
                if (s.charAt(i) == 'D') {
                    int j = i;
                    while (j < n && s.charAt(j) == 'D') {
                        j++;
                    }
                    reverse(perm, i, j);
                    i = j;
                }
                // System.out.println(Arrays.toString(perm));
            }
            return perm;
        }
    }
}
