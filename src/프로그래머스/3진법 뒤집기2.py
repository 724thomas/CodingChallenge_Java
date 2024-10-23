# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

class Solution {
    public String to3Bin(int n){
        int base = 3;
        String ans = "";

        while (n>0) {
            ans = (n % base) + ans;
            n /= base;
        }
        return ans;
    }

    public String reverse(String n){
        StringBuilder sb = new StringBuilder(n);
        return sb.reverse().toString();
    }

    public int from3Bin(String n){
        int len = n.length();
        int ans = 0;
        for (int i=0; i<len; i++) {
            int num = n.charAt(i) - '0';
            ans += num * Math.pow(3, len - 1 - i);
        }
        return ans;
    }

    public int solution(int n) {
        return from3Bin(reverse(to3Bin(n)));
    }
}

'''


