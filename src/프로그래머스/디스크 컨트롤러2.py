# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    현재 들어와있는 요청중에 가장 짧은 시간의 요청을 먼저 처리
    processes를 통해 들어온 시간 정렬
    waitList를 통해 현재까지 들어와있는 프로세스를 실행시간으로 정렬
2. 시간복잡도 :
    O(nlogn)
3. 자료구조 :
    우선순위큐

import java.util.*;
class Solution {
    class Process {
        int dur;
        int start;
        public Process(int start, int dur){
            this.dur = dur;
            this.start = start;
        }
    }

    public int solution(int[][] jobs) {
        int n = jobs.length;
        int ans = 0;

        PriorityQueue<Process> processes = new PriorityQueue<>((a,b) -> a.start - b.start);
        for (int[] job : jobs) processes.add(new Process(job[0], job[1]));
        PriorityQueue<Process> waitList = new PriorityQueue<>((a,b) -> a.dur - b.dur);

        int time = 0;
        while (!processes.isEmpty() || !waitList.isEmpty()){
            while (!processes.isEmpty() && processes.peek().start <= time) {
                waitList.add(processes.poll());
            }
            if (waitList.isEmpty()) {
                time = processes.peek().start;
                continue;
            }
            Process shortest = waitList.poll();
            time += shortest.dur;
            ans += time - shortest.start;
        }
        return ans/n;
    }
}

'''


