package dp;

import java.util.Arrays;

public class BuySellKTransactions {

    public int recSolution(int[] prices, int k) {
        return recursion(0, 0, prices, k);
    }

    private int recursion(int i, int state, int[] prices, int k) {
        if (k <= 0 || i >= prices.length) return 0;

        int doSomething, doNothing;

        doNothing = recursion(i + 1, state, prices, k);

        if (state == 0) {
            doSomething = recursion(i + 1, 1, prices, k) - prices[i];

        } else {
            doSomething = recursion(i + 1, 0, prices, k - 1) + prices[i];
        }

        return Math.max(doSomething, doNothing);
    }

    private int topDown(int[] prices, int k){
        int[][] dp = new int[k+1][prices.length];
        return recursionDP(1, 0, prices, k, dp);
    }

    private int recursionDP(int i, int state, int[] prices, int k, int[][] dp) {
        if (k <= 0 || i >= prices.length) return 0;
        if(dp[k][i]>0 ) {
            return dp[k][i];
        }

        int doSomething, doNothing;

        doNothing = recursionDP(i + 1, state, prices, k, dp);

        if (state == 0) {
            doSomething = recursionDP(i + 1, 1, prices, k, dp) - prices[i];

        } else {
            doSomething = recursionDP(i + 1, 0, prices, k - 1, dp) + prices[i];
        }
        return dp[k][i] = Math.max(doSomething, doNothing);
    }

    public int solution(int[] prices, int k) {
        int[][] dp = new int[k+1][prices.length];
        for(int i=0; i<k+1; i++) {
            int maxDiff = Integer.MIN_VALUE;
            for(int j=0; j<prices.length; j++) {
                if(i==0||j==0) {
                    dp[i][j] = 0;
                } else {
                    int noSell = dp[i][j-1];
                    maxDiff = Math.max(maxDiff, dp[i-1][j]-prices[j]);
                    int sell = prices[j]+maxDiff;
                    dp[i][j] = Math.max(noSell, sell);
                }
            }
        }
        return dp[k][prices.length-1];
    }

    public static void main(String[] args) {
        BuySellKTransactions buySellKTransactions = new BuySellKTransactions();
        System.out.println(buySellKTransactions.solution(new int[]{3,2,6,5,0,3}, 2));
    }
}
