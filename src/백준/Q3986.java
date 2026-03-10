// https://www.acmicpc.net/problem/
package 백준;

/*
1. 아이디어 :
스택으로 가장 최근 입력된 값이 다음 값과 같은지 확인

2. 시간복잡도 :
O( n*m )

3. 자료구조/알고리즘 :
스택
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Q3986 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i=0; i<n; i++) {
            String s = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.addLast(c);
                } else {
                    if (c == 'A') {
                        if (stack.peekLast() == 'B') {
                            stack.addLast(c);
                        } else {
                            stack.pollLast();
                        }
                    } else {
                        if (stack.peekLast() == 'A') {
                            stack.addLast(c);
                        } else {
                            stack.pollLast();
                        }
                    }
                }
            }
            if (stack.isEmpty()) ans++;
        }
        System.out.println(ans);
    }
}
