// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :

2. 시간복잡도 :
O( )
3. 자료구조 :


 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Q9012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String check(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() && c == ')') return "NO";

            if (stack.isEmpty() || c == '(') {
                stack.push(c);
            } else {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.size()==0? "YES":"NO";
    }
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            System.out.println(check(br.readLine()));
        }

    }
}
