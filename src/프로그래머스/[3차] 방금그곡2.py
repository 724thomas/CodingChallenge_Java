# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    Map<String, String> map1 = new HashMap<>();
    Map<String, String> map2 = new HashMap<>();
    public void initMap() {
        map1.put("A", "a");
        map2.put("A#", "b");
        map1.put("B", "c");
        map1.put("C", "d");
        map2.put("C#", "e");
        map1.put("D", "f");
        map2.put("D#", "g");
        map1.put("E", "h");
        map1.put("F", "i");
        map2.put("F#", "j");
        map1.put("G", "k");
        map2.put("G#", "l");
        map2.put("B#", "z");
    }

    public String getFull(String st, String et, String s) {
        int length = serialize(et) - serialize(st);
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length) sb.append(s);
        return sb.substring(0, length);
    }

    public int serialize(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0])*60 + Integer.parseInt(times[1]);
    }

    public String change(String s) {
        StringBuilder sb = new StringBuilder();
        for (var key : map2.keySet()) s = s.replace(key, map2.get(key));
        for (var key : map1.keySet()) s = s.replace(key, map1.get(key));
        return s;
    }

    public String solution(String m, String[] musicinfos) {
        initMap();
        m = change(m);

        String ans = "(None)";
        int cmax = 0;

        for (String info : musicinfos) {
            String[] info2 = info.split(",");
            String s = info2[0], e = info2[1], title = info2[2], cords = info2[3];
            int playTime = serialize(e) - serialize(s);
            String newcords = getFull(s, e, change(cords));

            if (newcords.contains(m) && playTime > cmax) {
                cmax = playTime;
                ans = title;
            }
        }
        return ans;
    }
}
'''



