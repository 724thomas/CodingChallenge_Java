# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :


class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int n1 = cards1.length, n2 = cards2.length;
        int idx1 = 0, idx2 = 0;

        for (int i=0; i<goal.length; i++){
            if (idx1 < n1 && cards1[idx1].equals(goal[i])) {
                idx1++;
            } else if (idx2 < n2 && cards2[idx2].equals(goal[i])){
                idx2++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}

'''


