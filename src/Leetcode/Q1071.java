package Leetcode;

/*
1. 아이디어 :
    1과 2를 순서를 다르게 합쳤을때 값이 서로 다르면 공통된 값이 없습니다.
    gcd를 사용해서 최대 공약수 길이만큼의 1의 길이가 정답입니다

2. 시간복잡도 :
O( n+m )

3. 자료구조/알고리즘 :
문자열
 */

public class Q1071 {
    class Solution {
        public int gcd(int a, int b) {
            if (b==0) return a;
            return gcd(b, a%b);
        }

        public String gcdOfStrings(String str1, String str2) {
            if (!(str1+str2).equals(str2+str1)) return "";

            if (str1.length() < str2.length()) {
                String temp = str1;
                str1 = str2;
                str2 = temp;
            }

            int gcdLength = gcd(str1.length(), str2.length());
            return str1.substring(0, gcdLength);
        }
    }
}
