package Leetcode;

public class Q1093 {
    class Solution {
        public double[] sampleStats(int[] count) {
            //min, max
            int min = -1;
            int max = 0;
            //mean, median
            int totalCount = 0;
            long totalSum = 0;
            //mode
            int modeCount=0;
            int mode=-1;

            for (int i=0; i<=255; i++) {
                if (count[i] == 0) continue;

                if (min==-1) min = i; //min
                max = i; // max

                //mean, median
                totalCount+=count[i];
                totalSum+=(long)count[i] * i;

                //mode
                if (count[i] > modeCount) {
                    modeCount = count[i];
                    mode = i;
                }
            }

            double mean = (double) totalSum / totalCount;

            //median
            double median = 0.0;
            int mid1 = (totalCount+1)/2;
            int mid2 = totalCount % 2 == 0 ? mid1+1 : mid1;

            int prefixCount = 0;
            int median1 = -1, median2 = -1;

            for (int i=0; i<=255; i++) {
                prefixCount += count[i];

                if (mid1 <= prefixCount && median1 == -1) {
                    median1 = i;
                }

                if (prefixCount >= mid2) {
                    median2 = i;
                    break;
                }
            }
            // System.out.println(median1 + " " + median2);
            median = (median1 + median2) / 2.0;

            return new double[]{min, max, mean, median, mode};

        }
    }
}
