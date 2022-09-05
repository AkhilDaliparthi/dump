package arrays;

public class CountSubArraysWithScoreLessThanK {

    public long countSubArrays(int[] nums, long k) {
        int res = 0;
        int start = 0;
        int sum = 0;
        for(int end=0; end<nums.length; end++) {
            sum+=nums[end];
            while((end-start+1)*sum>=k) {
                sum-=nums[start];
            }
            res += end-start+1;
        }
        return res;
    }

    public static void main(String[] args) {
        CountSubArraysWithScoreLessThanK countSubArraysWithScoreLessThanK = new CountSubArraysWithScoreLessThanK();
        System.out.println(countSubArraysWithScoreLessThanK.countSubArrays(new int[]{2,1,4,5}, 10));
    }
}
