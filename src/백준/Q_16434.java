// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Q_16434 {

    static long battle(long health, long attack, long ehealth, long eattack) {
        long damageTaken = ((ehealth + attack - 1) / attack - 1) * eattack;
        return health - damageTaken;
    }

    static boolean check(ArrayList<String[]> rooms, long hatk, long hmax) {
        long health = hmax;
        for (String[] room : rooms) {
            if (Integer.parseInt(room[0]) == 2) {
                hatk += Integer.parseInt(room[1]);
                health = Math.min(hmax, health + Integer.parseInt(room[2]));
            } else {
                long eatk = Long.parseLong(room[1]);
                long ehealth = Long.parseLong(room[2]);
                health = battle(health, hatk, ehealth,eatk);
                if (health <= 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        long n = Long.parseLong(inputs[0]);
        long attack = Long.parseLong(inputs[1]);

        ArrayList<String[]> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rooms.add(br.readLine().split(" "));
        }

        long left = 0;
        long right = Long.MAX_VALUE/2;
        for (String[] room: rooms){
            if (Integer.parseInt(room[0]) == 1) {
                long eatk = Long.parseLong(room[1]);
                long ehealth = Long.parseLong(room[2]);
                right += (long) eatk * ((ehealth + attack-1)/attack);
            }
        }

        while (left <= right) {
            long mid_health = left + (right - left) / 2;
            if (check(rooms, attack, mid_health)) {
                right = mid_health - 1;
            } else {
                left = mid_health + 1;
            }
        }

        System.out.println(left);
    }
}
