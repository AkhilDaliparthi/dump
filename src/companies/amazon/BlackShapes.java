package companies.amazon;

import java.util.LinkedList;
import java.util.Queue;

public class BlackShapes {

    public int solution(String[] A) {
        int m = A.length;
        int n = A[0].length();
        boolean [][] graph = new boolean[m][n];
        boolean [][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(A[i].charAt(j)=='X') {
                    graph[i][j] = true;
                }
            }
        }
        int count=0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(graph[i][j]==true && visited[i][j]==false) {
                    visit(graph, visited, i, j);
                    count++;
                }
                visited[i][j]=true;
            }
        }
        return count;
    }

    private void visit(boolean[][] graph, boolean[][] visited, int x, int y) {
        int[][] directions = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        while(!q.isEmpty()) {
            int[] curr = q.remove();
            visited[curr[0]][curr[1]] = true;
            for(int i=0; i<directions.length; i++) {
                int[] next = {curr[0]+directions[i][0], curr[1]+directions[i][1]};
                if(isValid(next, graph.length, graph[0].length) && visited[next[0]][next[1]]==false && graph[next[0]][next[1]]) {
                    q.add(next);
                }
            }
        }
    }
    private boolean isValid(int[] next, int m, int n) {
        if(next[0]<0 || next[1]<0 || next[0]>=m || next[1]>=n) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        BlackShapes blackShapes = new BlackShapes();
        System.out.println(blackShapes.solution(new String[]{"OOOXOOO", "OOXXOXO", "OXOOOXO"}));
    }
}
