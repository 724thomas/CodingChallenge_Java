package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3492 {
    class Solution {
        public int maxContainers(int n, int w, int maxWeight) {
            return Math.min(n*n, maxWeight/w);
        }
    }
}
