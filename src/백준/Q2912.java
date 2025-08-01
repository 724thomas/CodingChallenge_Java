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
import java.util.Collections;
import java.util.Random;

class Q2912 {

    static ArrayList<Integer>[] pos;
    static int[] dwarfColors; // 난쟁이들의 실제 모자 색상 (원본 배열)
    static Random random = new Random();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nc = br.readLine().split(" ");
        int N = Integer.parseInt(nc[0]); // 난쟁이 수
        int C = Integer.parseInt(nc[1]); // 모자 색상 수

        dwarfColors = new int[N + 1]; // 1-based index
        pos = new ArrayList[C + 1]; // 1-based index for colors
        for (int i = 1; i <= C; i++) {
            pos[i] = new ArrayList<>();
        }

        String[] colorsStr = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            dwarfColors[i] = Integer.parseInt(colorsStr[i - 1]);
            pos[dwarfColors[i]].add(i); // 해당 색상의 인덱스 리스트에 추가
        }

        int M = Integer.parseInt(br.readLine()); // 사진 수
        StringBuilder sb = new StringBuilder();

        // 각 쿼리 처리
        for (int q = 0; q < M; q++) {
            String[] ab = br.readLine().split(" ");
            int A = Integer.parseInt(ab[0]); // 시작 인덱스
            int B = Integer.parseInt(ab[1]); // 끝 인덱스
            int K = B - A + 1; // 사진에 찍힌 난쟁이 수

            boolean found = false;
            int sampleCount = 30;

            for (int s = 0; s < sampleCount; s++) {
                // 구간 [A, B] 내에서 랜덤 인덱스 선택
                int randomIndex = A + random.nextInt(K); // A <= randomIndex < A+K = B+1

                // 해당 인덱스의 난쟁이 모자 색상을 후보로
                int candidateColor = dwarfColors[randomIndex];

                // 후보 색상이 구간 [A, B] 내에서 몇 번 나타나는지 카운트
                // pos[candidateColor]는 해당 색상이 나타나는 모든 인덱스를 정렬한 리스트
                // lowerBound: 리스트에서 A 이상인 첫 번째 원소의 인덱스
                // upperBound: 리스트에서 B 이하인 마지막 원소의 인덱스 + 1
                int count = countOccurrences(pos[candidateColor], A, B);

                if (count * 2 > K) { // count > K/2 와 동일 (정수 연산 시 *2가 안전)
                    sb.append("yes ").append(candidateColor).append("\n");
                    found = true;
                    break;
                }
            }

            if (!found) {
                sb.append("no\n");
            }
        }

        System.out.print(sb.toString());
        br.close();
    }

    private static int countOccurrences(ArrayList<Integer> list, int lowerBound, int upperBound) {
        int firstIdx = Collections.binarySearch(list, lowerBound);
        if (firstIdx < 0) {
            firstIdx = -(firstIdx + 1); // 삽입 지점
        }

        int lastIdx = Collections.binarySearch(list, upperBound);
        if (lastIdx < 0) {
            lastIdx = -(lastIdx + 1); // 삽입 지점
        } else {
            lastIdx++; // 찾은 인덱스 다음부터 시작하도록.
            while(lastIdx < list.size() && list.get(lastIdx) <= upperBound) {
                lastIdx++;
            }
        }

        return lastIdx - firstIdx;
    }
}