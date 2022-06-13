package graph;

public class NetworkDelay {

    public int solution(int[][] times, int n, int k) {
        boolean[] visited = new boolean[n];
        int[] dis = new int[n];
        for(int i=0; i<n ;i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[k-1] = 0;
        for(int c=0; c<n; c++) {
            int next = findMinimum(dis, visited);
            if(next!=-1) {
                visited[next] = true;
                for(int i=0; i<times.length; i++) {
                    if(!visited[times[i][1]-1] && times[i][0]==next+1 && dis[times[i][1]-1]>dis[next]+times[i][2]) {
                        dis[times[i][1]-1] = dis[next]+times[i][2];
                    }
                }
            }
        }
        int res=0;
        for(int i=0; i<n; i++) {
            if(dis[i]==Integer.MAX_VALUE) {
                return -1;
            }
            if(res<dis[i]) {
                res = dis[i];
            }
        }
        return res;
    }

    public int findMinimum(int[] dis, boolean[] visited) {
        int next = -1;
        for(int i=0; i<dis.length; i++) {
            if(!visited[i] && (next==-1 || dis[i]<dis[next])) {
                next = i;
            }
        }
        return next;
    }


    public static void main(String[] args) {
        NetworkDelay networkDelay = new NetworkDelay();
        int[][] times = {{1,2,1},{2,3,2},{1,3,2}};
        System.out.print(networkDelay.solution(times, 3, 1));
    }
}
