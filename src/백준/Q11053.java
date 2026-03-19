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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Q11053 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> increasingNums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] inputs =  br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(inputs[i]);

        for (int num : nums) {
            int pos = getPos(num);
            if (pos == increasingNums.size()) {
                increasingNums.add(num);
            } else {
                increasingNums.set(pos, num);
            }
        }
        System.out.println(increasingNums.size());
    }

    public static int getPos(int num) {
        int left = 0, right = increasingNums.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (increasingNums.get(mid) <= num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
