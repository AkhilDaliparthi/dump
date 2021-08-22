package arrays;

import java.util.HashMap;

//https://leetcode.com/problems/two-sum/

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> temp = new HashMap<>(nums.length);
        int[] res = new int[2];
        for(int i=0; i<nums.length ; i++) {
            if(temp.containsKey(target-nums[i])) {
                res[0] = temp.get(target - nums[i]);
                res[1] = i;
                return res;
            } else {
                temp.put(nums[i],i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] nums = {-3,4,3,90};
        int[] res = solution.twoSum(nums, 0);
        System.out.print(res[0]+"\t"+res[1]);
    }
}
