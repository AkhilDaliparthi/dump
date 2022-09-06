package arrays;

public class RemoveDupliactes {

    public int solution(int[] nums) {
        int k = 0;
        for(int i=1; i<nums.length; i++) {
            while(i<nums.length && nums[k] == nums[i]) {
                i++;
            }
            if(i<nums.length && i!=k) {
                k++;
                nums[k] = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        RemoveDupliactes removeDupliactes = new RemoveDupliactes();
        System.out.println(removeDupliactes.solution(new int[]{0,0}));
    }
}
