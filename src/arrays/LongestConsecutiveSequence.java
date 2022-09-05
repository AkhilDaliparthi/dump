package arrays;

import java.util.HashMap;

public class LongestConsecutiveSequence {

    public int solution(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, true);
        }
        int max = 0;
        for(int i : map.keySet()) {
            if(map.get(i)) {
                int temp = i;
                int count = 1;
                map.put(i, false);
                while(map.get(i-1) != null) {
                    i--;
                    count++;
                    map.put(i, false);
                }
                i= temp;
                while(map.get(i+1) != null) {
                    i++;
                    count++;
                    map.put(i, false);
                }
                if(count>max) {
                    max = count;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        System.out.println(longestConsecutiveSequence.solution(new int[]{0,-1}));
    }
}
