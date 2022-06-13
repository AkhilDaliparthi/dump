package udemy.slidingwindow;

import udemy.arrays.SubarraySort;

public class SubArraySum {

    public int solution(int[] nums, int k){
        int count = 0;
        for(int i=1; i<=nums.length; i++) {
            int y=0;
            int sum=0;
            while(y<i){
                sum+=nums[y];
                y++;
            }
            if(sum==k) {
                count++;
            }
            for( ;y<nums.length; y++) {
                sum-=nums[y-i];
                sum+=nums[y];
                if(sum==k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SubArraySum subArraySum = new SubArraySum();
        System.out.println(subArraySum.solution(new int[]{1,1,1}, 2));
    }
}
