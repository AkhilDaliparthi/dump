package Linked;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {

    public int[] solution(int[] nums, Integer k) {
        int[] res = new int[nums.length-k+1];
        Deque<Integer> q = new LinkedList<>();
        int j=0;
        for(int i=0; i< nums.length; i++) {
            while(!q.isEmpty() && nums[q.peekLast()]<=nums[i]) {
                q.removeLast();
            }
            if(!q.isEmpty() && i-q.peek()>=k){
                q.removeFirst();
            }
            q.add(i);
            if(i>=k-1) {
                res[j] = nums[q.peek()];
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] res = maxSlidingWindow.solution(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        for(int i:res) {
            System.out.println(i);
        }
    }
}
