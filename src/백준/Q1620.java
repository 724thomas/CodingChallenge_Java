// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :

2. 시간복잡도 :
O( )
3. 자료구조 :


 */
import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Q1620 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String input;
    static String[] inputs;
    static int[] ninputs;

    public static void main(String[] args) throws IOException {
        HashMap<Integer, String> numToName = new HashMap<>();
        HashMap<String, Integer> nameToNum = new HashMap<>();
        inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]), m = Integer.parseInt(inputs[1]);
        for (int i = 0; i<n; i++) {
            input = br.readLine();
            numToName.put(i+1, input);
            nameToNum.put(input, i+1);
        }

        for (int i = 0; i<m; i++) {
            input = br.readLine();
            if (Character.isAlphabetic(input.charAt(0))) {
                System.out.println(nameToNum.get(input));
            } else {
                System.out.println(numToName.get(Integer.parseInt(input)));
            }
        }
    }
}
