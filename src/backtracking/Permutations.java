package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used) {
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                boolean isDuplicate = (i > 0 && nums[i] == nums[i-1] && !used[i - 1]);
                if(used[i] || isDuplicate) {
                    continue;
                }
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        List<List<Integer>> res = permutations.permute(new int[]{1,2,3,2});
        for(List<Integer> list : res) {
            for(Integer i : list) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }
}
