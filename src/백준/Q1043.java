// https://www.acmicpc.net/problem/
package 백준;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q1043 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parent;

    public static void main(String[] args) throws IOException {
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]), m = Integer.parseInt(inputs[1]);

        parent = new int[n+1];
        for (int i=1; i<=n; i++) {
            parent[i] = i;
        }

        String[] truthInput =  br.readLine().split(" ");
        int truthCount = Integer.parseInt(truthInput[0]);
        int[] truthPeople = new int[truthCount];
        for (int i=0; i<truthCount; i++){
            truthPeople[i] = Integer.parseInt(truthInput[i+1]);
        }

        List<int[]> parties = new ArrayList<>();

        for (int i=0; i<m; i++) {
            String[] partyInput = br.readLine().split(" ");
            int partySize = Integer.parseInt(partyInput[0]);

            int[] partyPeople = new int[partySize];
            for (int j=0; j<partySize; j++){
                partyPeople[j] = Integer.parseInt(partyInput[j+1]);
            }

            parties.add(partyPeople);

            for (int j=1; j<partySize; j++){
                union(partyPeople[0], partyPeople[j]);
            }
        }

        int ans = 0;

        for (int[] party : parties) {
            boolean canLie = true;

            for (int person : party) {
                for (int truthPerson : truthPeople) {
                    if (find(person) == find(truthPerson)) {
                        canLie = false;
                        break;
                    }
                }
                if (!canLie) break;
            }
            if (canLie) ans++;
        }

        System.out.println(ans);
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra != rb) {
            parent[rb] = ra;
        }
    }
}
