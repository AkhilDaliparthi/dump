package dp;

import java.util.Stack;

public class SumOfTotalStrengthOfWizards {

    final int mod = (int)1e9 + 7;
    long[] preSum;
    long[] prePreSum;
    long[] postSum;
    long[] postPostSum;
    public int solution(int[] nums) {
        int n = nums.length;
        long sum = 0;
        setPreAndPostSum(n, nums);
        Stack<Integer> monotonicStack = new Stack<>();
        for (int i = 0; i <= nums.length; i++) {
            while ( !monotonicStack.isEmpty() && (i == nums.length || nums[monotonicStack.peek()] >= nums[i])) {
                int middle = monotonicStack.pop();
                int left = monotonicStack.isEmpty() ? -1 : monotonicStack.peek();
                sum += getCurrentSum(nums[middle], left, middle, i);
            }
            if (i < nums.length) {
                monotonicStack.push(i);
            }
        }
        return (int)(sum % mod);
    }
    private void setPreAndPostSum(int n, int[] nums) {
        preSum = new long[n];
        prePreSum = new long[n];
        postSum = new long[n];
        postPostSum = new long[n];
        for(int i = 0; i < n; i++) {
            preSum[i] += (i == 0 ? 0 : preSum[i - 1]) + nums[i];
            prePreSum[i] += (i == 0 ? 0 : prePreSum[i - 1]) + preSum[i];
            int j = n - 1 - i;
            postSum[j] += (j == n - 1 ? 0 : postSum[j + 1]) + nums[j];
            postPostSum[j] += (j == n - 1 ? 0 : postPostSum[j + 1]) + postSum[j];
        }
    }
    private long getRightCount(int start, int end) {
        if (start == 0) return prePreSum[end - 1];
        return (prePreSum[end - 1] - prePreSum[start - 1] - preSum[start - 1] * (end - start)) % mod;
    }

    private long getLeftCount(int start, int end) {
        if (end == postPostSum.length - 1) return postPostSum[start + 1];
        return (postPostSum[start + 1] - postPostSum[end + 1] - postSum[end + 1] * (end - start)) % mod;
    }
    /*
    left includes current val, right does not include current value
    */
    private long getCurrentSum(int min, int start, int i, int end) {
        long left = getLeftCount(start, i) * (end - i) % mod;
        long right = getRightCount(i + 1, end) * (i - start) % mod;
        return min * (left + right) % mod;
    }

    public static void main(String[] args) {
        SumOfTotalStrengthOfWizards sumOfTotalStrengthOfWizards = new SumOfTotalStrengthOfWizards();
        System.out.println(sumOfTotalStrengthOfWizards.solution(new int[]{1,3,1,2}));
    }
}
