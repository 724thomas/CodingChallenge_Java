# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;

class Course {
    String menus;
    int freq;
    public Course(String menus, int freq) {
        this.menus = menus;
        this.freq= freq;
    }
}
class Solution {
    Map<String, Integer> allCourses = new HashMap<>();

    public void combinations(String s, String curr, int start, int r) {
        if (curr.length() == r) {
            allCourses.put(curr, allCourses.getOrDefault(curr, 0)+1);
            return;
        }

        for (int i=start; i<s.length(); i++) {
            combinations(s, curr+s.charAt(i), i+1, r);
        }
    }
    public String[] solution(String[] orders, int[] course) {
        for (String order : orders) {
            char[] charOrder = order.toCharArray();
            Arrays.sort(charOrder);
            order = new String(charOrder);
            for (int length = 2; length<=order.length(); length++) {
                combinations(order, "", 0, length);
            }
        }

        Map<Integer, List<Course>> lCourses= new HashMap<>();
        for (var entry : allCourses.entrySet()) {
            int length = entry.getKey().length();
            lCourses.putIfAbsent(length, new ArrayList<>());
            lCourses.get(length).add(new Course(entry.getKey(), entry.getValue()));
        }
        for (var val : lCourses.values()) {
            Collections.sort(val, (a,b) -> b.freq - a.freq);
        }

        List<String> ansList = new ArrayList<>();

        for (int length : course) {
            if (!lCourses.containsKey(length)) continue;
            int cmax = lCourses.get(length).get(0).freq;
            if (cmax < 2) continue;
            for (Course c : lCourses.get(length)){
                if (c.freq == cmax) {
                    ansList.add(c.menus);
                }
            }
        }

        Collections.sort(ansList);
        String[] ans = new String[ansList.size()];
        for (int i=0; i<ansList.size(); i++) ans[i] = ansList.get(i);
        return ans;
    }
}
'''



