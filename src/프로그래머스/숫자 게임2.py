# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


'''
import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int bp = n-1;
        int score = 0;
        for (int ap=n-1; ap>=0; ap--){
            if (A[ap] < B[bp]) {
                score++;
                bp--;
            }
        }

        return score;
    }
}'''
