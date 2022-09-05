package dp;

public class Uniquepaths {

    public int recSolution(int m, int n) {
        return travel(0,0, m, n);
    }

    public int travel(int i, int j, int m, int n) {
        if(i>=m || j>=n) {
            return 0;
        }
        if(i==m-1 && j==n-1) {
            return 1;
        }
        return  travel(i+1, j, m, n) + travel(i, j+1, m, n);
    }

    public int dpSolution(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=1; i<n; i++) {
            dp[0][i] = 1;
        }
        for(int i=1; i<m; i++) {
            dp[i][0] = 1;
        }

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Uniquepaths uniquepaths = new Uniquepaths();
        System.out.println(uniquepaths.dpSolution(3,7));
    }
}
