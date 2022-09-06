package dp;

public class CountOfSequences {

    public int recSolution(int[] nums, int[] pattern) {
        return recursion(nums, pattern, 0, 0);
    }

    public int recursion(int[] nums, int[] pattern, int i, int j) {
        if(i>=nums.length) {
            return 0;
        }
        if(nums[i]==pattern[j]) {
            int inc, exc = 0;
            if(j==pattern.length-1) {
                inc = 1;
                exc =  recursion(nums, pattern, i+1, j);
            } else {
                inc =  recursion(nums, pattern, i+1, j+1);
                exc =  recursion(nums, pattern, i+1, j);
            }
            return inc+exc;
        }
        return recursion(nums, pattern, i+1, j);
    }

    public int topDown(int[] nums, int[] pattern) {
        int[][] dp = new int[nums.length][pattern.length];
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<pattern.length; j++){
                dp[i][j]= -1;
            }
        }
        return topDownRecursion(nums, pattern, 0, 0, dp);
    }

    public int topDownRecursion(int[] nums, int[] pattern, int i, int j, int[][] dp) {
        if(i>=nums.length) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        if(nums[i]==pattern[j]) {
            int inc, exc = 0;
            if(j==pattern.length-1) {
                inc = 1;
                exc =  topDownRecursion(nums, pattern, i+1, j, dp);
            } else {
                inc =  topDownRecursion(nums, pattern, i+1, j+1, dp);
                exc =  topDownRecursion(nums, pattern, i+1, j, dp);
            }
            return dp[i][j] = inc+exc;
        }
        return dp[i][j] = recursion(nums, pattern, i+1, j);
    }

    public int bottomUp(int[] nums, int[] pattern) {
        int[][] dp = new int[nums.length+1][pattern.length+1];
        for(int j=1; j<=pattern.length; j++){
            dp[0][j] =0;
        }
        for(int i=0; i<=nums.length; i++){
            dp[i][0] =1;
        }
        for(int i=1; i<=nums.length; i++){
            for(int j=1; j<=pattern.length; j++){
                if(nums[i-1] == pattern[j-1]){//IF Match
                    dp[i][j] =  dp[i-1][j-1] + dp[i-1][j];//take + notTake
                }else{
                    dp[i][j] = dp[i-1][j];//Not Match
                }
            }
        }//for closes

        return dp[nums.length][pattern.length];
    }

    public static void main(String[] args) {
        CountOfSequences countOfSequences = new CountOfSequences();
        System.out.println(countOfSequences.bottomUp(new int[]{3, 4, 4, 6, 7, 8, 2, 6, 9, 2}, new int[]{4,6,2}));
    }
}
