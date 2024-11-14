// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :

2. 시간복잡도 :
O( )
3. 자료구조 :


 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Q21942 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] inputs;
    static int day;
    static int hour;
    static int minute;

    public static long calc_fee(String borrowTime, String returnTime, int penalty) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime borrowedTime = LocalDateTime.parse(borrowTime, formatter);
        LocalDateTime maxReturnTime = borrowedTime.plusDays(day).plusHours(hour).plusMinutes(minute);
        LocalDateTime returnedTime = LocalDateTime.parse(returnTime, formatter);

        if (!returnedTime.isAfter(maxReturnTime)) return 0;

        Long overdueMinutes = Duration.between(maxReturnTime, returnedTime).toMinutes();
        return overdueMinutes * penalty;

    }

    public static void main(String[] args) throws IOException {
        inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        String duration = inputs[1];
        int F = Integer.parseInt(inputs[2]);

        String[] durationInfo1 = duration.split("/");
        String[] durationInfo2 = durationInfo1[1].split(":");
        day = Integer.parseInt(durationInfo1[0]);
        hour = Integer.parseInt(durationInfo2[0]);
        minute = Integer.parseInt(durationInfo2[1]);

        Map<String, Map<String, String>> history = new HashMap<>(); //person :
        Map<String, Long> totalPenalty = new HashMap<>();
        for (int i=0; i<N; i++) {
            String[] inputs = br.readLine().split(" ");
            String time = inputs[0] + " " + inputs[1];
            String part = inputs[2];
            String name = inputs[3];

            history.putIfAbsent(name, new HashMap<>());
            totalPenalty.putIfAbsent(name, 0L);
            Map<String, String> personHistory = history.get(name);
            if (!personHistory.containsKey(part)) {
                personHistory.put(part, time);
            } else {
                String borrowedTime = personHistory.get(part);
                personHistory.remove(part);
                totalPenalty.put(name, totalPenalty.get(name) + calc_fee(borrowedTime, time, F));
            }
        }

        ArrayList<String[]> ans = new ArrayList<>();
        for (var entry : totalPenalty.entrySet()) {
            if (entry.getValue() <= 0) continue;
            ans.add(new String[]{entry.getKey(), String.valueOf(entry.getValue())});
        }
        if (ans.size() == 0) {
            System.out.println(-1);
            return;
        }

        Collections.sort(ans, (a,b) -> a[0].compareTo(b[0]));
        for (String[] a : ans) {
            System.out.println(a[0] + " " + a[1]);
        }
    }
}
