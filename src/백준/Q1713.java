// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    추천 회수 저장, 사진틀에 포함된 학생들을 저장하기 위한 배열을 만듭니다.
    각 추천을 순회하면서,
        추천이 사진틀에 포함되어있으면 단순히 추천을 증가.
        아니면 사진틀에 자리가 있는지 확인.
            자리가 없으면 사진틀에서 가장 적은 추천수를 가진 학생을 추출하고 리스트에서 제거한뒤 추천수 0
            자리가 있으면 사진틀에 추가
2. 시간복잡도 :
    O( n**2 )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q1713 {
    static int[] counter = new int[101];
    static List<Integer> pic = new ArrayList<>();

    public static int getMin() {
        int minStudent = pic.get(0);
        int minCount = counter[minStudent];

        for (int student : pic) {
            if (counter[student] < minCount) {
                minCount = counter[student];
                minStudent = student;
            }
        }
        return minStudent;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int num : nums) {
            if (pic.contains(num)) {
                counter[num]++;
            } else {
                if (pic.size() == N) {
                    int removeStudent = getMin();
                    pic.remove((Integer) removeStudent);
                    counter[removeStudent] = 0;
                }
                pic.add(num);
                counter[num] = 1;
            }
        }

        Collections.sort(pic);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pic.size(); i++) {
            sb.append(pic.get(i));
            if (i != pic.size() - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
