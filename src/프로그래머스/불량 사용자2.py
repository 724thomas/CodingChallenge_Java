'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    Map<String, ArrayList<String>> candids;
    Set<Set<String>> ans = new HashSet<>();

    public boolean check(String a, String b){
        if (a.length() != b.length()) return false;
        for (int i=0; i<a.length(); i++){
            if (a.charAt(i)=='*') continue;
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public ArrayList<String> get_candids(String s, String[] user_ids){
        ArrayList<String> candids = new ArrayList<>();
        int n = s.length();
        for (var user_id : user_ids){
            if (check(s, user_id)) candids.add(user_id);
        }
        return candids;
    }

    public void combinations(ArrayList<ArrayList<String>> candidates, Set<String> currSet, int idx) {
        if (idx == candidates.size()) {
            ans.add(new HashSet<>(currSet));
            return;
        }

        for (String user: candidates.get(idx)) {
            if (!currSet.contains(user)) {
                currSet.add(user);
                combinations(candidates, currSet, idx+1);
                currSet.remove(user);
            }
        }

    }

    public int solution(String[] user_ids, String[] banned_ids) {
        ArrayList<ArrayList<String>> candidates = new ArrayList<>();
        for (var banned_id: banned_ids){
            candidates.add(get_candids(banned_id, user_ids));
        }
        combinations(candidates, new HashSet<>(), 0);
        return ans.size();

    }
}



'''


