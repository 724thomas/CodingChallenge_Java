package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1559 {
    class Solution {
        int count = 0;
        int[][] visited;
        char[][] grid;
        int n, m;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        public boolean dfs(int x,int y,int px,int py, char c){

            if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]!=c)
                return false;

            if(visited[x][y]-visited[px][py]>=3)
                return true;

            if(visited[x][y]!=0)
                return false;

            visited[x][y]=count++;

            for (int i=0; i<4; i++) {
                if (dfs(x + dx[i], y + dy[i], x, y, c)) return true;
            }
            return false;
        }
        public boolean containsCycle(char[][] grid) {
            this.grid = grid;
            n = grid.length;
            m = grid[0].length;
            visited = new int[n][m];

            for(int i=0;i<n;i++) for(int j=0;j<m;j++){
                if(visited[i][j]==0 && dfs(i,j,i,j,grid[i][j])) return true;
            }
            return false;
        }
    }
}
