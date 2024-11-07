# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    가장 뒤 0 에 110들을 넣어주거나,
    가장 앞 1 앞에 110들을 넣어주면 된다.
2. 시간복잡도 :
    O( n * m )
3. 자료구조 :
    스택

import java.util.*;
class Solution {
    public String[] count110 (String s) {
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        for (var c : s.toCharArray()) {
            if (stack.size() >= 2) {
                char pprev = stack.get(stack.size()-2);
                char prev = stack.get(stack.size()-1);
                char curr = c;
                if (pprev == '1' && prev == '1' && curr == '0') {
                    stack.pop();
                    stack.pop();
                    ans++;
                } else {
                    stack.add(c);
                }
            } else {
                stack.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return new String[]{String.valueOf(ans), sb.reverse().toString()};
    }

    public String[] solution(String[] s) {
        String[] ans = new String[s.length];

        for (int k=0; k<s.length; k++){
            String[] res = count110(s[k]);
            int count = Integer.parseInt(res[0]);
            String leftOver = res[1];

            int insertIdx = leftOver.length();
            boolean found = false;

            // after last 0
            for (int i=leftOver.length()-1; i>-1; i--) {
                if (leftOver.charAt(i) == '0'){
                    insertIdx = i+1;
                    found = true;
                break;`
                }
            }

            //infront of first 11
            if (!found) {
                for (int i = 0; i<leftOver.length(); i++) {
                    if (leftOver.charAt(i) == '1') {
                        insertIdx = i;
                        break;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append(leftOver.substring(0, insertIdx));
            for (int i=0; i<count; i++) sb.append("110");
            sb.append(leftOver.substring(insertIdx, leftOver.length()));

            ans[k] = sb.toString();
        }
        return ans;
    }
}
'''


def solution(s):

    def count110(string):
        count_110 = 0
        stack = []

        for char in string:
            stack.append(char)
            if len(stack) >= 3 and stack[-3:] == ['1', '1', '0']:
                count_110 += 1
                for _ in range(3):
                    stack.pop()
        return count_110, "".join(stack)

    ans = []

    for string in s:
        count_110, string = count110(string)

        index = len(string)
        found = False

        for i in range(len(string) - 1, -1, -1):
            if string[i] == '0':
                index = i + 1
                found = True
                break

        if not found:
            for i in range(len(string)):
                if string[i] == '1':
                    index = i
                    break

        ans.append(string[:index] + ("110" * count_110) + string[index:])

    return ans
