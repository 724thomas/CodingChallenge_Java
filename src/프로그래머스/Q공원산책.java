package 프로그래머스;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q공원산책 {
    String[] park, routes;
    int n, m;

    public int[] getNextCord(int x, int y, String route) {
        String[] r = route.split(" ");
        Character D = r[0].charAt(0);
        int moves = Integer.parseInt(r[1]);

        int nx = x, ny = y;
        for (int i=0; i<moves; i++) {
            if (D=='W') {
                ny--;
            } else if (D=='E') {
                ny++;
            } else if (D=='N') {
                nx--;
            } else if (D=='S') {
                nx++;
            }
            if (nx<0 || nx>=n || ny<0 || ny>= m || park[nx].charAt(ny) == 'X') {
                return new int[]{x, y};
            }
        }
        return new int[]{nx, ny};
    }
    public int[] solution(String[] park, String[] routes) {
        this.park = park;
        this.routes = routes;
        n = park.length;
        m = park[0].length();
        int x = -1, y = -1;
        for (int i = 0; i<n; i++) for (int j=0; j<m; j++) {
            if (park[i].charAt(j) == 'S') {
                x = i;
                y = j;
                break;
            }
        }

        for (String route : routes) {
            int[] nextCord = getNextCord(x, y, route);
            x = nextCord[0];
            y = nextCord[1];
        }

        return new int[]{x, y};
    }
}
