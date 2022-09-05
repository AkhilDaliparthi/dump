package dp;

public class MinimumCoinChange {

    public int recSolution(int[] coins, int amount) {
        if(amount==0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++) {
            if(amount>=coins[i]) {
                int temp = recSolution(coins, amount-coins[i]);
                if(temp+1<min && temp!= Integer.MAX_VALUE) {
                    min = temp+1;
                }
            }
        }
        return min;
    }

    public int solution(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i=1; i<=amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j=0; j<coins.length; j++) {
                if(coins[j]<=i) {
                    int count = dp[i-coins[j]];
                    if(count != Integer.MAX_VALUE && count+1<dp[i]) {
                        dp[i] = count+1;
                    }
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1: dp[amount];
    }

    public static void main(String[] args) {
        MinimumCoinChange minimumCoinChange = new MinimumCoinChange();
        int[] coins = {2,3,5,10};

        System.out.println(minimumCoinChange.solution(coins, 15));
    }
}
