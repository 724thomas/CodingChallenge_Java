package Leetcode.java;

/*
1. 아이디어 :
arr길이는 20배수이니까, 길이/20 만큼 양쪽을 잘라내고 평균을 구한다.

2. 시간복잡도 :
O( n log n )  // 정렬

3. 자료구조/알고리즘 :
- / -
 */

import java.util.Arrays;

public class Q1619 {
    class Solution {
        public double trimMean(int[] arr) {
            Arrays.sort(arr);
            int n = arr.length;
            int startIdx = arr.length/20;
            double total = 0;
            for (int i=startIdx; i<n-startIdx; i++) total+=arr[i];
            return total / (n - 2*startIdx);
        }
    }
}
