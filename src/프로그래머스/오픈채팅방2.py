# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    실시간으로 업데이트가 필요없기때문에, 마지막에 이름만 바꿔주면 시간을 줄일 수 있다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    해시맵

import java.util.*;
class Solution {
    ArrayList<String> history = new ArrayList<>();
    Map<String, String> uidNameMapper = new HashMap<>();
    Map<String, String> msgTypeAndContent = new HashMap<>();

    public String[] solution(String[] record) {
        msgTypeAndContent.put("Enter", "+");
        msgTypeAndContent.put("+", "님이 들어왔습니다.");
        msgTypeAndContent.put("Leave", "-");
        msgTypeAndContent.put("-", "님이 나갔습니다.");

        for (String r : record) {
            String[] info = r.split(" ");
            if (info[0].equals("Change")) {
                uidNameMapper.put(info[1], info[2]);
            } else {
                history.add(msgTypeAndContent.get(info[0]) + info[1]);
                if (info[0].equals("Enter")) {
                    uidNameMapper.put(info[1], info[2]);
                }
            }
        }

        String[] ans = new String[history.size()];
        for (int i=0; i<history.size(); i++) {
            String log = history.get(i);
            String name = uidNameMapper.get(log.substring(1, log.length()));
            ans[i] = name + msgTypeAndContent.get(log.substring(0,1));
        }
        return ans;
    }
}
'''


def solution(record):
    history = []
    uid_name_mapper = {}
    msgTypeAndContent = {"Enter" : "+", "+" : "님이 들어왔습니다.",
                         "Leave" : "-", "-": "님이 나갔습니다."}

    for r in record:
        info = r.split(" ")
        if info[0] == "Change":
            uid_name_mapper[info[1]] = info[2]
        else:
            history.append(msgTypeAndContent[info[0]] + info[1])
            if info[0] == "Enter":
                uid_name_mapper[info[1]] = info[2]

    ans = []
    for i in range(len(history)):
        log = history[i]
        name = uid_name_mapper[log[1:]]
        ans.append(name + msgTypeAndContent[log[0]])

    return ans