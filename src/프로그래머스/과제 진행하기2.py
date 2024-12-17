# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    -
2. 시간복잡도 :
    O(    )
3. 자료구조 :
    -
import java.util.*;

class Solution {
    public int serialize(String time) {
        String[] time2 = time.split(":");
        return Integer.parseInt(time2[0]) * 60 + Integer.parseInt(time2[1]);
    }

    public String[] solution(String[][] plans) {
        int N = plans.length;
        Arrays.sort(plans, (a,b) -> serialize(a[1]) - serialize(b[1]));

        String[] subjects = new String[N];
        int[] starts = new int[N];
        int[] durations = new int[N];
        for (int i=0; i<N; i++) {
            subjects[i] = plans[i][0];
            starts[i] = serialize(plans[i][1]);
            durations[i] = Integer.parseInt(plans[i][2]);
        }
        Deque<String[]> waitStack = new ArrayDeque<>();
        List<String> ans = new ArrayList<>();

        String curSub = subjects[0];
        int curEnd = starts[0] + durations[0];
        int curRemain = durations[0];

        for (int i = 1; i < N; i++) {
            int nextStart = starts[i];
            String nextSub = subjects[i];
            int nextDur = durations[i];

            if (curEnd <= nextStart) {
                ans.add(curSub);
                int currentTime = curEnd;

                while (!waitStack.isEmpty()) {
                    String[] paused = waitStack.pollLast();
                    int pausedRemain = Integer.parseInt(paused[1]);
                    if (currentTime + pausedRemain <= nextStart) {
                        currentTime += pausedRemain;
                        ans.add(paused[0]);
                    } else {
                        int left = pausedRemain - (nextStart - currentTime);
                        waitStack.addLast(new String[]{paused[0], String.valueOf(left)});
                        currentTime = nextStart;
                        break;
                    }
                }

                curSub = nextSub;
                curRemain = nextDur;
                curEnd = nextStart + nextDur;
            } else {
                int usedTime = nextStart - (curEnd - curRemain);
                int remain = curRemain - usedTime;

                waitStack.addLast(new String[]{curSub, String.valueOf(remain)});

                curSub = nextSub;
                curRemain = nextDur;
                curEnd = nextStart + nextDur;
            }
        }
        ans.add(curSub);

        while (!waitStack.isEmpty()) {
            String[] paused = waitStack.pollLast();
            ans.add(paused[0]);
        }

        return ans.toArray(new String[0]);
    }
}

'''



