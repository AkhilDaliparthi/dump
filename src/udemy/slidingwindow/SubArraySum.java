package udemy.slidingwindow;

import java.util.HashMap;

public class SubArraySum {

    public int solution(int[] nums, int k){
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        int i=0;
        map.put(0,1);
        while(i<nums.length) {
            sum+=nums[i];
            if(map.containsKey(sum-k)) {
                count+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        SubArraySum subArraySum = new SubArraySum();
        System.out.println(subArraySum.solution(new int[]{1,1,1}, 2));
    }
}
