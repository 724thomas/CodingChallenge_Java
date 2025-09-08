package Leetcode.java;

public class Q215 {
    public int findKthLargest(int[] nums, int k) {
        int cmax = -Integer.MAX_VALUE;
        int cmin = Integer.MAX_VALUE;
        for (int num:nums){
            cmax = Math.max(cmax, num);
            cmin = Math.min(cmin, num);
        }

        int[] counter = new int[cmax-cmin+1];
        for (int num:nums){
            counter[num-cmin]++;
        }

        for (int i=counter.length-1; i>=0; i--){
            if (k > counter[i]) {
                k-=counter[i];
            } else {
                return i + cmin;
            }
        }
        return 1;
    }
}
