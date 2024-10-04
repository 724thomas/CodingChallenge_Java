# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public String[][] toBin(int[] arr, int n){
        String[][] barr = new String[n][n];
        for (int row=0; row<n; row++){
            int value = arr[row];
            for (int col=n-1; col>=0; col--){
                if (value >= Math.pow(2,col)) {
                    value -= Math.pow(2,col);
                    barr[row][n-col-1] = "#";
                } else {
                    barr[row][n-col-1] = " ";
                }
            }
        }
        return barr;
    }
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[][] barr1 = toBin(arr1, n);
        String[][] barr2 = toBin(arr2, n);
        String[] ans = new String[n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (barr1[i][j] == "#" || barr2[i][j] == "#") {
                    barr1[i][j] = "#";
                } else {
                    barr1[i][j] = " ";
                }
            }
            ans[i] = String.join("", barr1[i]);
        }
        return ans;
    }
}

'''


def solution(n, arr1, arr2):
    ans = []
    for i in range(n):
        a, b = bin(arr1[i])[2:], bin(arr2[i])[2:]
        a, b = "0" * (n-len(a)) + a, "0" * (n-len(b)) + b
        ans.append("".join(["#" if a[i] == "1" or b[i] == "1" else " " for i in range(n)]))
    return ans