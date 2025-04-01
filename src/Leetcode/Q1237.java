package Leetcode;

/*
1. 아이디어 :
f(x,y) 중 z를 만족하는 x,y를 찾습니다.
각 범위는 <=1000 이기 때문에 브루트포스로 해결합니다.
최적화를 위해, f(x,y)이 z보다 크면 break합니다.

2. 시간복잡도 :
O( n^2 )

3. 자료구조/알고리즘 :
- / 브루트포스
 */

import java.util.ArrayList;
import java.util.List;

public class Q1237 {
    /*
     * // This is the custom function interface.
     * // You should not implement it, or speculate about its implementation
     * class CustomFunction {
     *     // Returns f(x, y) for any given positive integers x and y.
     *     // Note that f(x, y) is increasing with respect to both x and y.
     *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
     *     public int f(int x, int y);
     * };
     */
    /*
    class Solution {
        public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
            List<List<Integer>> ans = new ArrayList<>();
            for (int i=1; i<1001; i++) {
                if (customfunction.f(i,1) > z) break;

                for (int j=1; j<1001; j++) {
                    int val = customfunction.f(i,j);
                    if (val > z) break;
                    if (val==z) {
                        ans.add(new ArrayList<>(List.of(i, j)));
                    }
                }
            }
            return ans;
        }
    }
    */
}
