package dp;

public class Knapsack {

    public int recSolution(int[] values, int[] weights, int target){
        return recursion(values.length-1, values, weights, target);
    }

    private int recursion(int index, int[] values, int[] weights, int target) {
        if(target==0||index<0) {
            return 0;
        }
        if(weights[index]>target) {
            return recursion(index-1, values, weights, target);
        }
        return Math.max(values[index]+recursion(index-1 , values, weights, target-weights[index]), recursion(index-1 , values, weights, target));
    }

    public int solution(int[] values, int[] weights, int target) {
        int[][] dp = new int[weights.length+1][target+1];
        for(int w=1; w<=target; w++) {
            for(int n=1; n<weights.length+1; n++) {
                int inc=0;
                if(weights[n-1]<=w) {
                    inc = values[n-1]+dp[n-1][w-weights[n-1]];
                }
                int exc = dp[n-1][w];
                dp[n][w] = Math.max(inc, exc);
            }
        }
        return dp[weights.length][target];
    }

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        System.out.println(knapsack.solution(new int[] {6,10,12}, new int[]{1,2,3}, 5));
    }
}
