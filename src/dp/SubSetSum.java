package dp;

public class SubSetSum {

    public int recSolution(int[] nums, int target) {
        return recursion(0, 0, nums, target);
    }

    public int recursion(int currSum, int i, int[] nums, int target) {
        if(i>=nums.length || currSum>target) {
            return 0;
        }
        if(currSum+nums[i]==target) {
            return 1+ recursion(currSum+nums[i], i+1, nums, target);
        }
        return recursion(currSum+nums[i], i+1, nums, target) + recursion(currSum, i+1, nums, target);
    }

    public int solution(int[] nums, int target) {
        int[][] dp = new int[nums.length+1][target+1];
        for(int i=0; i<=nums.length; i++) {
            dp[i][0] = 1;
        }
        for(int i=1; i<=nums.length; i++) {
            for(int j=1; j<=target; j++) {
                if(nums[i-1]-j>0) {
                    dp[i][j]= dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][target];
    }

    public static void main(String[] args) {
        SubSetSum subSetSum = new SubSetSum();
        System.out.println(subSetSum.solution(new int[]{2, 3, 5, 6, 8, 10}, 10));
    }
}
