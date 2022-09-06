package dp;

public class CoinChange {

    public int solution(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i=0; i<coins.length; i++) {
            for(int j=coins[i]; j<=amount; j++) {
                dp[j] = dp[j]+dp[j-coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.solution(new int[]{1, 2, 5}, 5));
    }
}
