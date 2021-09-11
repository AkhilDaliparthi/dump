package arrays;

import java.util.List;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int k = 0;
        for(int i=0; i<nums.length; i++) {
            while(i<nums.length-1 && nums[i]==nums[i+1]) {
                i++;
            }
            nums[k] = nums[i];
            k++;
        }
        return k;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int res = solution.removeDuplicates(nums);
        for(int i=0; i<res; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
