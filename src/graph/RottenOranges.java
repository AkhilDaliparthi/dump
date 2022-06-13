package graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        int res = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        boolean rotten = true;
        while(rotten) {
            rotten = false;
            Queue<int[]> que = new LinkedList<>();
            for(int i=0; i<grid.length; i++) {
                for(int j=0; j<grid[0].length; j++) {
                    if(grid[i][j]==2 && !visited[i][j]) {
                        que.add(new int[]{i,j});
                        visited[i][j] = true;
                    }
                }
            }
            if(!que.isEmpty()) {
                res = res + markRotten(grid, visited, que, res);
                rotten = true;
            }
        }
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==1) {
                    return -1;
                }
            }
        }
        return res;
    }

    public int markRotten(int[][] grid, boolean[][] visited, Queue<int[]> que, int res) {
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        Queue<int[]> nextQ = new LinkedList<>();
        while(!que.isEmpty()) {
            int[] curr = que.poll();
            for(int i=0; i<directions.length; i++){
                int[] next = {curr[0]+directions[i][0], curr[1]+directions[i][1]};
                if(isValid(next, grid) && !visited[next[0]][next[1]] && grid[next[0]][next[1]]==1) {
                    grid[next[0]][next[1]] = 2;
                    visited[next[0]][next[1]] = true;
                    nextQ.add(next);
                }
            }
        }
        if(!nextQ.isEmpty()) {
           return markRotten(grid, visited, nextQ, res+1);
        }
        return res;
    }

    public boolean isValid(int[] next, int[][] grid) {
        if(next[0]<0 || next[1]<0 || next[0]>= grid.length || next[1]>= grid[0].length ) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        RottenOranges rottenOranges = new RottenOranges();
        int[][] grid = {{2,1,1},{1,1,1},{0,1,2}};
        System.out.println(rottenOranges.orangesRotting(grid));
    }
}
