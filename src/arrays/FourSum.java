package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/4sum/

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++) {
            if(i==0 || (nums[i] != nums[i-1])) {
                for(int j=i+1; j<nums.length-2; j++) {
                    if(j==i+1 || (nums[j] != nums[j-1])) {
                        int low = j + 1;
                        int high = nums.length - 1;
                        while (low < high) {
                            if (nums[i] + nums[j] + nums[low] + nums[high] == target) {
                                res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                                while (low < high && nums[low] == nums[low + 1]) {
                                    low++;
                                }
                                while (low < high && nums[high] == nums[high - 1]) {
                                    high--;
                                }
                                low++;
                                high--;
                            } else if (nums[i] + nums[j] + nums[low] + nums[high] < target) {
                                low++;
                            } else {
                                high--;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FourSum solution = new FourSum();
        int[] nums = {-2,-1,-1,1,1,2,2};
        List<List<Integer>> resList = solution.fourSum(nums, 0);
        for(List<Integer> res : resList) {
            for(Integer num : res) {
                System.out.print(num + " ");
            }
        }
    }
}
