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
import java.util.Arrays;

class Q18185 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String inputN = br.readLine();
        int n = Integer.parseInt(inputN);

        // 라면 공장별 필요한 라면 개수를 저장하는 배열
        // 인덱스 오류 방지를 위해 N+2 크기로 생성하고 0으로 초기화
        int[] ramens = new int[n + 2];
        String[] ramenCounts = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            ramens[i] = Integer.parseInt(ramenCounts[i]);
        }

        long totalCost = 0;

        for (int i = 0; i < n; i++) {
            if (ramens[i] == 0) continue;

            // case 1: i+1 공장과 i+2 공장의 라면 개수를 비교
            // ramens[i+1] > ramens[i+2] 인 경우는 i, i+1, i+2를 묶는 것보다 i, i+1을 먼저 묶고 남은 i, i+1, i+2를 묶는게 이득일 수 있음
            if (ramens[i + 1] > ramens[i + 2]) {
                // 현재 공장 i의 라면을 모두 소비하거나, i+1과 i+2의 차이만큼만 2개 묶음으로 구매 (i, i+1을 묶어서 사는 것을 최대한 먼저 시도 (5원))
                int buyTwoRamenOnly = Math.min(ramens[i], ramens[i + 1] - ramens[i + 2]);
                totalCost += (long) buyTwoRamenOnly * 5;
                ramens[i] -= buyTwoRamenOnly;
                ramens[i + 1] -= buyTwoRamenOnly;
            }

            // case 2: i, i+1, i+2 모두에 라면이 필요한 경우 (3개 묶음 구매)
            // 또는 위 case 1 처리 후 남은 i, i+1, i+2에 대해 3개 묶음 구매
            int buyThreeRamen = Math.min(ramens[i], Math.min(ramens[i + 1], ramens[i + 2]));
            totalCost += (long) buyThreeRamen * 7;
            ramens[i] -= buyThreeRamen;
            ramens[i + 1] -= buyThreeRamen;
            ramens[i + 2] -= buyThreeRamen;

            // case 3: i, i+1에만 라면이 필요한 경우 (2개 묶음 구매)
            // (위에서 이미 3개 묶음 처리 후 남은 라면에 대해)
            int buyTwoRamen = Math.min(ramens[i], ramens[i + 1]);
            totalCost += (long) buyTwoRamen * 5;
            ramens[i] -= buyTwoRamen;
            ramens[i + 1] -= buyTwoRamen;

            // case 4: i에만 라면이 필요한 경우 (1개 묶음 구매)
            // (위에서 모든 묶음 처리 후 남은 라면에 대해)
            totalCost += (long) ramens[i] * 3;
            ramens[i] = 0; // i 공장의 라면은 모두 처리되었으므로 0으로 설정
        }

        System.out.println(totalCost);
    }
}