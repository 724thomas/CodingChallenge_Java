package Leetcode;

import java.util.PriorityQueue;

public class Q1882 {
    class Solution {
        public int[] assignTasks(int[] servers, int[] tasks) {
            PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
                if (a[0] != b[0]) return a[0]-b[0];
                return a[1]-b[1];
            }); // weight, idx
            for (int i=0; i<servers.length; i++) freeServers.add(new int[]{servers[i], i});

            PriorityQueue<int[]> workingServers = new PriorityQueue<>((a,b) -> {
                if (a[0] != b[0]) return a[0]-b[0];
                if (a[1] != b[1]) return a[1]-b[1];
                return a[2]-b[2];
            }); // finishTime, weight, idx

            int[] ans = new int[tasks.length];
            int time = 0;

            for (int i=0; i<tasks.length; i++) {
                time = Math.max(time, i);

                while (!workingServers.isEmpty() && workingServers.peek()[0] <= time) {
                    int[] freeServer = workingServers.poll();
                    freeServers.add(new int[]{freeServer[1], freeServer[2]});
                };

                if (freeServers.isEmpty()) {
                    time = workingServers.peek()[0];
                    while (!workingServers.isEmpty() && workingServers.peek()[0] <= time) {
                        int[] server = workingServers.poll();
                        freeServers.add(new int[]{server[1], server[2]});
                    }
                }

                int[] server = freeServers.poll();
                ans[i] = server[1];
                workingServers.offer(new int[]{time + tasks[i], server[0], server[1]});
            }

            return ans;
        }
    }
}
