# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''
'''
class Solution {
    static int check(String b) {
        for (int i=0; i<b.length()-1; i++) {
            if (b.charAt(i) == b.charAt(i+1)) {
                return 0;
            }
            if (Character.isAlphabetic(b.charAt(i))) {
                return 0;
            }
        }
        if (Character.isAlphabetic(b.charAt(b.length()-1))){
            return 0;
        }
        return 1;
    }
    
    public int solution(String[] babbling) {
        int count = 0;
        for (int i=0; i<babbling.length; i++){
            babbling[i] = babbling[i].replace("aya","1");
            babbling[i] = babbling[i].replace("ye", "2");
            babbling[i] = babbling[i].replace("woo", "3");
            babbling[i] = babbling[i].replace("ma", "4");
            count += check(babbling[i]);
        }
        
        return count;
    }
}'''
