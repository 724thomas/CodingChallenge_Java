# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length, m = arr2[0].length, k = arr1[0].length;
        int[][] ans = new int[n][m];
        for (int row=0; row<n; row++){
            for (int col=0; col<m; col++){
                for (int i=0; i<k; i++){
                    ans[row][col] += arr1[row][i] * arr2[i][col];
                }
            }
        }
        return ans;
    }
}

'''

def solution(arr1, arr2):
    return [[sum(arr1[row][i] * arr2[i][col] for i in range(len(arr2))) for col in range(len(arr2[0]))] for row in range(len(arr1))]
