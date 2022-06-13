package graph;

public class Prims {

    public int solution(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        int[] parent = new int[graph.length];
        int[] dis = new int[graph.length];
        for(int i=0; i<graph.length; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[0]=0;
        parent[0]=-1;
        for(int i=0; i<graph.length; i++) {
            int u = findNearest(visited, dis);
            visited[u] = true;
            for(int v=0; v<graph.length; v++) {
                if(graph[u][v]!=0 && !visited[v] && graph[u][v]<dis[v]) {
                    parent[v] = u;
                    dis[v] = graph[u][v];
                }
            }
        }
        int cost = 0;
        for(int i : dis) {
            if(i!=Integer.MAX_VALUE) {
                cost+=i;
            }
        }
        return cost;
    }

    public int findNearest(boolean[] visited, int[] dis) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i=0; i<visited.length; i++) {
            if(visited[i]==false && dis[i]<min) {
                min = dis[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        Prims prims = new Prims();
        int[][] graph = { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };
        System.out.print(prims.solution(graph));
    }
}
