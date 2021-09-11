package arrays;

import java.util.*;

//https://leetcode.com/problems/3sum/

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int k = 0;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i< nums.length-2 ; i++) {
            if (i == 0 || (nums[i] != nums[i-1])) {
                int low = i + 1;
                int high = nums.length - 1;
                while (low < high) {
                    if (nums[low] + nums[high] + nums[i] == k) {
                        List<Integer> temp = new ArrayList<>(3);
                        temp.add(nums[i]);
                        temp.add(nums[low]);
                        temp.add(nums[high]);
                        res.add(temp);

                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }

                        low++;
                        high--;
                    } else if(nums[low] + nums[high] + nums[i] < k) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        int[] nums = {-2,0,1,1,2};
        List<List<Integer>> resList = solution.threeSum(nums);
        for(List<Integer> res : resList) {
            for(Integer num : res) {
                System.out.print(num + " ");
            }
        }
    }
}
