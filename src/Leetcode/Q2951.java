package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q2951 {
    class Solution {
        public List<Integer> findPeaks(int[] mountain) {
            List<Integer> ans = new ArrayList<>();
            for (int i=1; i<mountain.length-1; i++) {
                if (mountain[i-1] < mountain[i] && mountain[i] > mountain[i+1]) ans.add(i);
            }
            return ans;
        }
    }
}
