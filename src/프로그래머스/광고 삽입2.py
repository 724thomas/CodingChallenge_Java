# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    누적합을 통해 해당 시간(초)에 시청자를 구한다.
    슬라이딩 윈도우를 통해서 최대값을 갱신
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열

import java.util.*;
class Solution {
    public int serialize(String time){
        String[] hms = time.split(":");
        return Integer.parseInt(hms[0])*3600 + Integer.parseInt(hms[1]) * 60 + Integer.parseInt(hms[2]);
    }

    public String deserialize(int num) {
    int hours = num / 3600;
    int minutes = (num % 3600) / 60;
    int seconds = num % 60;

    StringBuilder sb = new StringBuilder();
    if (hours < 10) sb.append("0");
    sb.append(hours).append(":");
    if (minutes < 10) sb.append("0");
    sb.append(minutes).append(":");
    if (seconds < 10) sb.append("0");
    sb.append(seconds);
    return sb.toString();
}


    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = serialize(play_time);
        int advDuration = serialize(adv_time);
        int[] prefixSum = new int[playTime + 1];

        for (String log : logs){
            String[] times = log.split("-");
            int start = serialize(times[0]), end = serialize(times[1]);
            prefixSum[start]++;
            prefixSum[end]--;
        }

        for (int i=1; i<playTime; i++) {
            prefixSum[i] += prefixSum[i-1];
        }

        long cmax = 0;
        for (int i=0; i<advDuration; i++) cmax += prefixSum[i];

        long curr = cmax;
        int ans = 0;

        for (int start = 1; start + advDuration <= playTime; start++) {
            curr += prefixSum[start + advDuration - 1] - prefixSum[start-1];
            if (curr > cmax) {
                cmax = curr;
                ans = start;
            }
        }

        return deserialize(ans);
    }
}

'''

def solution(play_time, adv_time, logs):
    def serialize(time):
        h, m, s = time.split(":")
        return int(h) * 3600 + int(m) * 60 + int(s)

    def deserialize(num):
        h = str(num // 3600)
        if len(h) == 1:
            h = "0" + h
        num = num % 3600
        m = str(num // 60)
        if len(m) == 1:
            m = "0" + m
        num = num % 60
        s = str(num)
        if len(s) == 1:
            s = "0" + s
        return h + ":" + m + ":" + s

    play_time = serialize(play_time)
    adv_duration = serialize(adv_time)

    prefix_sum = [0] * (play_time+1)

    for log in logs:
        times = log.split("-")
        prefix_sum[serialize(times[0])]+=1
        prefix_sum[serialize(times[1])]-=1

    for i in range(1, play_time):
        prefix_sum[i] += prefix_sum[i-1]

    cmax = 0
    for i in range(adv_duration): cmax += prefix_sum[i]

    curr = cmax
    ans = 0

    for start in range(1, play_time-adv_duration + 1):
        curr += prefix_sum[start + adv_duration - 1] - prefix_sum[start -1]
        if (curr > cmax):
            cmax = curr
            ans = start

    return deserialize(ans)


