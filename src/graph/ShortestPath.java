package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {

    public int solution(int source, int dest, ArrayList<ArrayList<Integer>> edges) {
        boolean[] visited = new boolean[edges.size()];
        Queue<Integer> que = new LinkedList<>();
        int[] dis = new int[edges.size()];
        que.add(source);
        visited[source] = true;
        while(!que.isEmpty()) {
            int u = que.poll();
            for(Integer i : edges.get(u)) {
                if(!visited[i]) {
                    visited[i] = true;
                    dis[i] = dis[u]+1;
                    que.add(i);
                }
            }
        }
        return dis[dest];
    }

    public static void main(String[] args) {
        ShortestPath shortestPath = new ShortestPath();
        int v = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 2);
        addEdge(adj, 3, 4);
        addEdge(adj, 3, 7);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 6);
        addEdge(adj, 4, 7);
        addEdge(adj, 5, 6);
        addEdge(adj, 6, 7);
        int source = 0, dest = 7;
        shortestPath.solution(source, dest, adj);
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j)
    {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }
}
