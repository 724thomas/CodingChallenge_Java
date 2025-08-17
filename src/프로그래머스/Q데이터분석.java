package 프로그래머스;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q데이터분석 {

    class Solution {
        public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
            Map<String, Integer> map = new HashMap<>();
            map.put("code", 0);
            map.put("date", 1);
            map.put("maximum", 2);
            map.put("remain", 3);

            Arrays.sort(data, (a, b) -> {
                return a[map.get(sort_by)] - b[map.get(sort_by)];
            });

            List<int[]> ans = new ArrayList<>();
            for (int[] d : data) {
                if (d[map.get(ext)] < val_ext) {
                    ans.add(d);
                }
            }
            int[][] answer = new int[ans.size()][4];
            for (int i=0; i<ans.size(); i++) answer[i] = ans.get(i);
            return answer;
        }
    }
}
