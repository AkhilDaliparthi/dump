package dp;

public class HouseRobber {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[1] = nums[0];
        for(int i=2; i<=nums.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        int[] houses = {1,2,3,1};
        System.out.println(houseRobber.rob(houses));
    }
}
