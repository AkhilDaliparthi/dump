package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumFlightStops {

    public int solution(int n, int[][] flights, int src, int dst, int k) {
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE/2);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, src, k+1});
        dis[src] = 0;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(curr[2]>0) {
                for(int i=0; i<flights.length; i++) {
                    if(flights[i][0]==curr[1] && dis[flights[i][1]]>curr[0]+flights[i][2]) {
                        q.add(new int[]{curr[0]+flights[i][2], flights[i][1], curr[2]-1});
                        dis[flights[i][1]] = curr[0]+flights[i][2];
                    }
                }
            }
        }
        return dis[dst]==Integer.MAX_VALUE/2 ? -1 : dis[dst];
    }

    public static void main(String[] args) {
        MinimumFlightStops minimumFlightStops = new MinimumFlightStops();
        System.out.print(minimumFlightStops.solution(4, new int[][]{{0,1,1},{1,2,1},{0,2,5},{2,3,1}},0, 3, 1));
    }
}
