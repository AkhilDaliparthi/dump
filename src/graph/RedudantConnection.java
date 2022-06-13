package graph;

public class RedudantConnection {

    public int[] solution(int[][] edges) {
        int[] res = new int[2];
        int[] parents = new int[edges.length];
        for(int i=0; i<edges.length; i++) {
            int parentX = findParent(parents, edges[i][0]);
            int parentY = findParent(parents, edges[i][1]);
            if(parentX==parentY) {
                res[0] = edges[i][0];
                res[1] = edges[i][1];
            } else {
                if(parentX<=parentY) {
                    parents[parentY] = edges[i][0];
                    parents[parentX] = parents[parentX]-2;
                } else {
                    parents[parentX] = edges[i][1];
                    parents[parentY] = parents[parentY]-2;
                }
            }
        }
        return res;
    }

    public int findParent(int[] parents, int edge) {
        if(parents[edge-1]>0) {
           return findParent(parents, parents[edge-1]);
        }
        return edge-1;
    }

    public static void main(String[] args) {
        RedudantConnection connection = new RedudantConnection();
        int[] res = connection.solution(new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}});
        System.out.println(res[0]+"\t"+res[1]);
    }
}
