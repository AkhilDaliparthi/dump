package dp;

public class CoinChange2 {

    public int recSolution(int[] coins, int amount) {
        return recursive(coins, 0, amount);
    }

    public int recursive(int[] coins, int index, int amount) {
        if(amount==0) {
            return 1;
        }
        if(amount<0 || index>=coins.length) {
            return 0;
        }
        return recursive(coins, index, amount-coins[index]) + recursive(coins, index+1, amount);
    }

    public int bottomUp(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin : coins) {
            for(int i=coin; i<=amount; i++) {
                dp[i] = dp[i] + dp[i-coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange2 coinChange2 = new CoinChange2();
        System.out.print(coinChange2.bottomUp(new int[]{2, 3, 5, 7}, 15));
    }
}
