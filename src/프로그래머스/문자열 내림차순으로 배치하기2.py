# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(nlogn)
3. 자료구조 :
    우선순위큐
import java.util.*;
class Solution {
    public class Char{
        int ord;
        char c;

        public Char(int ord, char c){
            this.ord = ord;
            this.c = c;
        }
    }

    public String solution(String s) {
        PriorityQueue<Char> pq = new PriorityQueue<>((a,b) -> b.ord - a.ord);
        for (var c : s.toCharArray()) pq.add(new Char(c-0, c));
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) sb.append( pq.poll().c);
        return sb.toString();
    }
}

'''



def solution(s):
    return "".join(sorted(list(s), key = lambda x: -ord(x)))