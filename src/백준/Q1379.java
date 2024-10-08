// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q1379 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> courses = new ArrayList<>();
        for (int i=0; i<n; i++) {
            String[] inputs = br.readLine().split(" ");
            courses.add(new int[]{Integer.parseInt(inputs[0]),Integer.parseInt(inputs[1]),Integer.parseInt(inputs[2])});
        }
        Collections.sort(courses, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> emptyRooms = new PriorityQueue<>();
        for (int i=0; i<n; i++) emptyRooms.offer(i+1);

        Map<Integer, Integer> ansMap = new HashMap<>();
        PriorityQueue<int[]> taken = new PriorityQueue<>((a, b) -> a[0] - b[0]); //endtime , room
        int max = 0;
        for (int[] course : courses){
            int num = course[0], start = course[1], end = course[2];

            while (!taken.isEmpty() && taken.peek()[0] <= start){
                int[] finished = taken.poll();
                emptyRooms.add(finished[1]);
            }

            int nextRoom = emptyRooms.poll();
            ansMap.put(num, nextRoom);
            taken.add(new int[]{end, nextRoom});
            max = Math.max(max, taken.size());
        }
        System.out.println(max);
        for (int i=0; i<n; i++) {
            System.out.println(ansMap.get(i+1));
        }
    }
}
