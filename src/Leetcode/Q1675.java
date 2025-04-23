package Leetcode;

/*
1. 아이디어 :
모든 수를 짝수로 만들어서 나눌 수 있도록 만든다.
우선순위큐에 넣으면서 최소값을 구한다. (내림차순 정렬)

반복:
    큐에서 가장 큰 값을 꺼내면서, 현재 최소값과의 차이를 구하고 ans를 갱신.
    가장 큰 값을 2로 나눌 수 없다면, 이 값이 최대 값이 되고, 그 외에 다른 값들을 나눴을때 최소값이 더 커질 수 없으므로 break
    가장 큰 값을 2로 나누고, 최소값을 갱신한다.
    큐에 넣는다.

2. 시간복잡도 :
O( nlogn + nlogM * logN ) nlogM : 하나의 숫자를 홀수로 만들기 위해서 최대 logM번 나누는 횟수.

3. 자료구조/알고리즘 :
우선순위큐 / 그리디
 */

import java.util.PriorityQueue;

public class Q1675 {
    class Solution {
        public int minimumDeviation(int[] nums) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a); //내림차순
            int cmin = Integer.MAX_VALUE;

            //짝수로 만든다.
            for (int num : nums) { //nlogn
                if (num%2==1) num*=2;
                pq.add(num);
                cmin = Math.min(cmin, num);
            }

            int ans = Integer.MAX_VALUE;

            while (true) { // nlog M
                int maxNum = pq.poll(); // 제일 큰 값을 꺼내고 logN
                ans = Math.min(ans, maxNum-cmin); // 제일 큰값과 제일 작은 값의 차이 저장
                if (maxNum % 2 == 1) break; // 제일 큰 값을 더 이상 나눌 수 없으면 종료

                maxNum /= 2; // 제일 큰 값을 2로 나눔
                cmin = Math.min(cmin, maxNum); // 최소값 갱신
                pq.add(maxNum);
            }


            return ans;

        }
    }
}
