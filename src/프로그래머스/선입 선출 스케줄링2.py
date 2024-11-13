# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public int countCompletedTasksIn(int time, int[] cores){
        int completedTasks = 0;
        for (int core: cores) {
            completedTasks += time/core;
        }
        return completedTasks;
    }

    public ArrayList<Integer> getIdleCore(int time, int[] cores) {
        ArrayList<Integer> candids = new ArrayList<>();
        for (int i=0; i<cores.length; i++) {
            if (time % cores[i] == 0) candids.add(i);
        }
        return candids;
    }

    public int solution(int n, int[] cores) {
        if (n <= cores.length) return n;
        n -= cores.length;

        int minTime = 0, maxTime = 0;
        for (int core: cores) maxTime = Math.max(maxTime, core * n);

        while (minTime < maxTime) {
            int midTime = (minTime + maxTime) / 2;
            int completedTasks = countCompletedTasksIn(midTime, cores);

            if (completedTasks >= n) {
                maxTime = midTime;
            } else {
                minTime = midTime + 1;
            }
        }

        int leftTasks = n - countCompletedTasksIn(minTime-1, cores);

        return getIdleCore(minTime, cores).get(leftTasks-1)+1;


        /*
        if (n <= cores.length) return n;

        int m = cores.length;

        PriorityQueue<int[]> coreFinishTimes = new PriorityQueue<>((a,b) -> {
            if (a[0] == b[0]) return a[1]-b[1];
            return a[0]-b[0];
        }); // finishTime, core

        for (int i=0; i<m; i++) coreFinishTimes.offer(new int[]{cores[i], i});
        n -= m;

        while (n>1) {
            int[] nextCoreInfo = coreFinishTimes.poll();
            int finishTime = nextCoreInfo[0], nextCore = nextCoreInfo[1];
            coreFinishTimes.offer(new int[]{cores[nextCore] + finishTime, nextCore});
            n-=1;
        }

        return coreFinishTimes.poll()[1]+1;
        */
    }
}
'''


