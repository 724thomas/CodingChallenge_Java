# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    -
2. 시간복잡도 :
    O( n * m )
3. 자료구조 :
    -

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i=0; i<m; i++){
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<n; j++){
                sb.append("*");
            }
            System.out.println(sb.toString());
        }
    }
}
'''


m, n = map(int, input().strip().split(' '))
for i in range(n):
    temp = ""
    for j in range(m):
        temp+="*"
    print(temp)