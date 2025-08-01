// https://www.acmicpc.net/problem/
package 백준;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Q2261 {

    static class Point implements Comparable<Point> {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            if (this.x == other.x) {
                return this.y - other.y;
            }
            return this.x - other.x;
        }

        public long distSq(Point other) {
            long dx = this.x - other.x;
            long dy = this.y - other.y;
            return dx * dx + dy * dy;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] coords = br.readLine().split(" ");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            points.add(new Point(x, y));
        }

        Collections.sort(points);

        for (int i = 0; i < n - 1; i++) {
            if (points.get(i).x == points.get(i+1).x && points.get(i).y == points.get(i+1).y) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(findClosestPair(points, 0, n - 1));

        br.close();
    }

    public static long findClosestPair(List<Point> points, int start, int end) {
        int numPoints = end - start + 1;

        if (numPoints <= 3) {
            long minDist = Long.MAX_VALUE;
            for (int i = start; i <= end; i++) {
                for (int j = i + 1; j <= end; j++) {
                    minDist = Math.min(minDist, points.get(i).distSq(points.get(j)));
                }
            }
            return minDist;
        }

        int mid = start + (end - start) / 2;
        Point midPoint = points.get(mid); // 중앙 점 (x좌표 기준)

        long leftMin = findClosestPair(points, start, mid);
        long rightMin = findClosestPair(points, mid + 1, end);
        long minDist = Math.min(leftMin, rightMin);

        List<Point> strip = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if ((long)(points.get(i).x - midPoint.x) * (points.get(i).x - midPoint.x) < minDist) {
                strip.add(points.get(i));
            }
        }

        Collections.sort(strip, Comparator.comparingInt(p -> p.y));

        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size(); j++) {
                if ((long)(strip.get(j).y - strip.get(i).y) * (strip.get(j).y - strip.get(i).y) >= minDist) {
                    break;
                }
                minDist = Math.min(minDist, strip.get(i).distSq(strip.get(j)));
            }
        }

        return minDist;
    }
}