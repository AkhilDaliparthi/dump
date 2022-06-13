package graph;

public class Dijkstras {

    public int[] solution(int[][] graph) {
        int[] dis = new int[graph.length];
        boolean[] visited = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[0]=0;
        for(int count=0; count<graph.length; count++) {
            int i = selectVertex(dis, visited);
            visited[i] = true;
            for(int j=0; j<graph[i].length; j++) {
                if(graph[i][j]>0 && (dis[j]==Integer.MAX_VALUE || dis[i]+graph[i][j]<dis[j])) {
                    dis[j] = dis[i]+graph[i][j];
                }
            }
        }
        return dis;
    }

    public int selectVertex(int[] dis, boolean[] visited) {
        int vertex=0;
        int minDis = Integer.MAX_VALUE;
        for(int i=0; i< dis.length; i++) {
            if(!visited[i] && dis[i]<minDis) {
                vertex = i;
                minDis = dis[i];
            }
        }
        return vertex;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        Dijkstras dijkstras = new Dijkstras();
        for(int i : dijkstras.solution(graph)){
            System.out.println(i);
        }
    }
}
