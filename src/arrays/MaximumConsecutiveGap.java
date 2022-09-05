package arrays;

import java.util.Arrays;

public class MaximumConsecutiveGap {

    public int solution(final int[] nums) {

        if(nums.length < 2)
            return 0;

        int n = nums.length;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int interval = (int)Math.ceil((max - min + 0.0) / (n - 1));

        int[] minBucket = new int[n - 1];
        int[] maxBucket = new int[n - 1];

        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, -1);

        for(int i = 0; i < n; i++){
            if(nums[i] == min || nums[i] == max)
                continue;
            int bucketIndex = (nums[i] - min) / interval;
            minBucket[bucketIndex] = Math.min(minBucket[bucketIndex], nums[i]);
            maxBucket[bucketIndex] = Math.max(maxBucket[bucketIndex], nums[i]);
        }

        int prev = min;
        int maxGap = 0;

        for(int i = 0; i < n - 1; i++){
            if(maxBucket[i] == -1)
                continue;
            maxGap = Math.max(minBucket[i] - prev, maxGap);
            prev = maxBucket[i];
        }

        maxGap = Math.max(max - prev, maxGap);

        return maxGap;
    }



    public static void main(String[] args) {
        MaximumConsecutiveGap maximumConsecutiveGap = new MaximumConsecutiveGap();
        System.out.println(maximumConsecutiveGap.solution(new int[]{1, 10, 5}));
    }
}
