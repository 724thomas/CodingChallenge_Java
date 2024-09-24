'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :




import java.util.*;
class Solution {
    public boolean check(int student, int answer, int idx) {
        if (student == 1) {
            int[] p1 = {1, 2, 3, 4, 5};
            return answer == p1[idx % p1.length];
        } else if (student == 2) {
            int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
            return answer == p2[idx % p2.length];
        } else {
            int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
            return answer == p3[idx % p3.length];
        }
    }

    public int[] solution(int[] answers) {
        int s1 = 0, s2 = 0, s3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (check(1, answers[i], i)) s1++;
            if (check(2, answers[i], i)) s2++;
            if (check(3, answers[i], i)) s3++;
        }

        int cmax = Math.max(s1, Math.max(s2,s3));
        List<Integer> ans = new ArrayList<>();
        if (s1 == cmax) ans.add(1);
        if (s2 == cmax) ans.add(2);
        if (s3 == cmax) ans.add(3);
        return ans.stream().mapToInt(i->i).toArray();
    }
}
'''


