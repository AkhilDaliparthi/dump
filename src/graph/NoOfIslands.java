package graph;

import com.sun.tools.javac.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslands {

    public int solution(char[][] grid) {
        int res = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j]=='1' && !visited[i][j]) {
                    markIsland(grid, i, j, visited);
                    res++;
                }
            }
        }
        return res;
    }
     public void markIsland(char[][] grid, int i, int j, boolean[][] visited) {
        int[][] neighbors = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{i,j});
        grid[i][j] = '0';
         while(!que.isEmpty()){
            int[] curr = que.poll();
             visited[curr[0]][curr[1]] = true;
             for(int n=0; n<neighbors.length; n++) {
                 int[] next = new int[]{curr[0]+neighbors[n][0], curr[1]+neighbors[n][1]};
                 if(isValid(next[0], next[1], grid.length, grid[0].length) && grid[next[0]][next[1]]=='1' && !visited[next[0]][next[1]]) {
                     grid[next[0]][next[1]] = '0';
                     que.add(next);
                 }
             }
        }
     }

     public boolean isValid(int nx, int ny, int m, int n) {
        if(nx>=0 && ny>=0 && nx<m && ny<n) {
            return true;
        }
        return false;
     }

    public static void main(String[] args) {
        NoOfIslands noOfIslands = new NoOfIslands();
        char[][] grid = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}};
        System.out.println(noOfIslands.solution(grid));
    }
}
