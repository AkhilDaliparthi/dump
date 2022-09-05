package dp;

public class JumpGame {

    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        topDown(nums, 0, dp);
        return dp[nums.length-1];
    }

    public boolean recSolution(int[] nums, int pos) {
        if(pos==nums.length-1) {
            return true;
        }
        for(int i=1; i<=nums[pos]; i++) {
            if(pos+i<nums.length && recSolution(nums, pos+i)) {
                return true;
            }
        }
        return false;
    }

    public boolean topDown(int[] nums, int pos, boolean[] dp) {
        if(dp[pos]) {
            return true;
        }
        if(pos==nums.length-1) {
            dp[pos] = true;
            return true;
        }
        if(pos<nums.length) {
            dp[pos] = true;
        }
        for(int i=1; i<=nums[pos]; i++) {
            if(pos+i<nums.length && topDown(nums, pos+i, dp)) {
                return true;
            }
        }
        return dp[pos];
    }

    public boolean bottomUp(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        if(nums[0]==0) {
            if(nums.length==1) {
                return true;
            }
            return dp[nums.length-1];
        }
        dp[0] = true;
        for(int i=1; i<=nums[0] && i<nums.length; i++) {
            dp[i] = true;
        }
        for(int i=1; i<nums.length; i++) {
            if(!dp[i]) {
                return dp[nums.length-1];
            }
            for(int j=1; j<=nums[i] && i+j<nums.length; j++) {
                dp[i+j] = true;
            }
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.bottomUp(new int[]{2,5,0,0}));
    }
}
