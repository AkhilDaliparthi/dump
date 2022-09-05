package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        getCombinations(res, new ArrayList<>(), nums);
        return res;
    }

    private void getCombinations(List<List<Integer>> res, List<Integer> temp, int[] nums) {
        if(temp.size()==nums.length) {
            res.add(new ArrayList<>(temp));
            return ;
        }
        for(int i=0; i<nums.length; i++) {
            if(!temp.contains(nums[i])) {
                temp.add(nums[i]);
                getCombinations(res, temp, nums);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        List<List<Integer>> res = permutations.permute(new int[]{1,2,3});
        for(List<Integer> list : res) {
            for(Integer i : list) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }
}
