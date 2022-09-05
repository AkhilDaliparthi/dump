package dp;

public class JumpGame2 {

    int min = Integer.MAX_VALUE;

    public int solution(int[] nums) {
        return topDown(nums, 0, new int[nums.length]);
    }

    public void recSolution(int[] nums, int pos, int count) {
        if(pos==nums.length-1) {
            if(min>count) {
                min = count;
            }
            return ;
        }
        if(pos<nums.length) {
            for(int i=1; i<=nums[pos]; i++) {
                if(pos+i<nums.length) {
                    recSolution(nums, pos+i, count+1);
                }
            }
        }
    }


    public int topDown(int[] nums, int pos, int[] dp) {
        if(pos>=nums.length-1) {
            return 0;
        }
        if(dp[pos] != 0) {
            return dp[pos];
        }
        int minimum = Integer.MAX_VALUE;
        for(int i=1; i<=nums[pos]; i++) {
            if(pos+i<nums.length) {
                minimum = Math.min(minimum, 1+topDown(nums, pos+i, dp));
            }
        }
        dp[pos] = minimum;
        return minimum;
    }

    public int bottomUp(int[] nums) {
        int steps = 0;
        int i = 0;
        while(i<nums.length-1) {
            int max = 0;
            int curr = nums[i];
            int next = i;
            if(i+curr>=nums.length-1) {
                return steps+1;
            }
            while(curr>0) {
                if(i+curr<nums.length && i+curr+nums[i+curr]>max) {
                    max = i+curr + nums[i+curr];
                    next = i+curr;
                }
                curr--;
            }
            steps++;
            i = next;
        }
        return steps;
    }



    public static void main(String[] args) {
        JumpGame2 jumpGame2 = new JumpGame2();
        System.out.println(jumpGame2.bottomUp(new int[]{2,3,1}));
    }
}
