package dp;

public class LongestIncreasingSubSequence {

    int max = 0;
    public int recSolution(int[] nums) {
        for(int i=0; i<nums.length-1; i++) {
            recursion(i, i+1, nums, 0);
        }
        return max;
    }

    private void recursion(int prev, int curr, int[] nums, int count) {
        if(count>max) {
            max = count;
        }
        if(curr>=nums.length) {
            return;
        }
        if(nums[curr]>nums[prev]) {
            recursion(curr, curr+1, nums, count+1);
        } else {
            recursion(prev, curr+1, nums, count+1);
        }
    }

    public int solution(int[] nums) {
        int[] counts = new int[nums.length+1];
        counts[0] = 1;
        for(int i=1; i<nums.length; i++) {
            counts[i] = 1;
            for(int j=0; j<i; j++) {
                if(nums[j]<nums[i] && counts[i]<=counts[j]) {
                    counts[i] = counts[j]+1;
                }
            }
        }
        int max = 0;
        for(int i:counts) {
            if(max<i){
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubSequence longestIncreasingSubSequence = new LongestIncreasingSubSequence();
        System.out.println(longestIncreasingSubSequence.solution(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}
