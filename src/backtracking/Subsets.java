package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrackSets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void backTrackSets(int[] nums, int start, List<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList<>(list));
        for(int i=start; i<nums.length; i++) {
            list.add(nums[i]);
            backTrackSets(nums, i+1, list, result);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> result = subsets.solution(new int[]{1,2,3});
        for(List<Integer> set : result) {
            for(Integer i : set) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }
}
