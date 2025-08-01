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
import java.util.Arrays; // Arrays 임포트 추가

class Q18186 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] params = br.readLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int B = Integer.parseInt(params[1]);
        int C = Integer.parseInt(params[2]);

        // 라면 공장별 필요한 라면 개수를 저장하는 배열
        // 인덱스 오류 방지를 위해 N+2 크기로 생성하고 0으로 초기화
        int[] ramens = new int[n + 2];
        String[] ramenCounts = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            ramens[i] = Integer.parseInt(ramenCounts[i]);
        }

        long totalCost = 0;

        // B <= C 인 경우, 묶음으로 사는 것이 손해이거나 이득이 없음.
        // 이 때는 무조건 낱개로 사는 것이 최적.
        if (B <= C) {
            for (int i = 0; i < n; i++) {
                totalCost += (long) ramens[i] * B;
            }
            System.out.println(totalCost);
            return; // 계산 후 종료
        }

        // B > C 인 경우 (묶음 구매가 이득인 경우)
        for (int i = 0; i < n; i++) {
            if (ramens[i] == 0) continue;

            // i+1과 i+2 공장 라면 개수 비교에 따른 전략
            // ramens[i+1] > ramens[i+2] 이면,
            // i, i+1을 묶는 것 (B+C)을 최대한 먼저 사용하고,
            // 남은 i, i+1, i+2를 묶는 것 (B+2C)을 사용
            // 이렇게 하는 이유는 B+C가 B+2C보다 (개당 효율 관점에서) 좋을 수도 있기 때문
            // (즉, 2개짜리 묶음을 선호하는 경우)
            if (ramens[i + 1] > ramens[i + 2]) {
                // i, i+1 묶음 구매를 먼저 시도 (i+2에 라면이 없어도 가능한 구매)
                // 현재 i의 라면 개수와 (i+1 - i+2) 라면 개수 중 더 작은 만큼 구매
                int buyTwoRamenOnly = Math.min(ramens[i], ramens[i + 1] - ramens[i + 2]);
                totalCost += (long) buyTwoRamenOnly * (B + C); // 2개 묶음 비용
                ramens[i] -= buyTwoRamenOnly;
                ramens[i + 1] -= buyTwoRamenOnly;
            }

            // 이제 i, i+1, i+2의 라면 개수가 (상대적으로) 비슷하거나 i+1 <= i+2인 상태가 됨.
            // 3개 묶음 구매 시도
            int buyThreeRamen = Math.min(ramens[i], Math.min(ramens[i + 1], ramens[i + 2]));
            totalCost += (long) buyThreeRamen * (B + 2 * C); // 3개 묶음 비용
            ramens[i] -= buyThreeRamen;
            ramens[i + 1] -= buyThreeRamen;
            ramens[i + 2] -= buyThreeRamen;

            // 3개 묶음 처리 후 남은 i, i+1에 대해 2개 묶음 구매 시도
            int buyTwoRamen = Math.min(ramens[i], ramens[i + 1]);
            totalCost += (long) buyTwoRamen * (B + C); // 2개 묶음 비용
            ramens[i] -= buyTwoRamen;
            ramens[i + 1] -= buyTwoRamen;

            // 모든 묶음 처리 후 i에 남은 라면은 낱개로 구매
            totalCost += (long) ramens[i] * B; // 1개 묶음 비용
            ramens[i] = 0; // 현재 공장의 라면 처리 완료
        }

        System.out.println(totalCost);
    }
}