package 프로그래머스;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class 추억점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int n = photo.length;
        int[] ans = new int[n];
        Map<String, Integer> names = new HashMap<>();
        for (int i=0; i<name.length; i++) {
            names.put(name[i], yearning[i]);
        }

        int idx = 0;
        for (String[] p : photo) {
            int total = 0;
            for (String person : p) {
                total += names.getOrDefault(person, 0);
            }
            ans[idx++] = total;
        }

        return ans;
    }
}
