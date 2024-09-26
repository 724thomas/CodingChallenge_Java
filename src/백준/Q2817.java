// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Q2817 {

    public static class Score{
        String name;
        double votes;

        public Score(String name, double votes){
            this.name = name;
            this.votes = votes;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double minimum = n * 0.05;
        int k = Integer.parseInt(br.readLine());

        PriorityQueue<Score> pq = new PriorityQueue<>((a, b) -> {
            if (a.votes > b.votes) return -1;
            return 1;
        });

        for (int i=0; i<k; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            double vote = Double.parseDouble(input[1]);
            if (vote<minimum) continue;
            for (int j=1; j<=14; j++) {
                pq.offer(new Score(name, vote / j));
            }
        }

        Map<String, Integer> chips = new HashMap<>();
        for (int i=0; i<14; i++) {
            String name = pq.poll().name;
            chips.put(name, chips.getOrDefault(name, 0) +1);
        }
        List<String> ans = new ArrayList<>(chips.keySet());
        Collections.sort(ans);
        for (String name : ans) {
            System.out.println(name + " " + chips.get(name));
        }
    }
}
