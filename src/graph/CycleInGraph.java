package graph;

import java.util.ArrayList;

public class CycleInGraph {

    public boolean DFSUtil(ArrayList<ArrayList<Integer>> graph, boolean[] visited, Integer start, Integer parent) {
        if(!visited[start]) {
          visited[start] = true;
          for(Integer i : graph.get(start)) {
              if(visited[i] && i!=parent) {
                  return true;
              }
              if(!visited[i]) {
                  return DFSUtil(graph, visited, i, start);
              }
          }
        }
        return false;
    }

    public boolean solution(ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        return DFSUtil(graph, visited, 0, 0);
    }

    public static void main(String[] args) {
        CycleInGraph cycleInGraph = new CycleInGraph();
        int v = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 0);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 3);
        System.out.println(cycleInGraph.solution(adj));
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j)
    {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }
}
