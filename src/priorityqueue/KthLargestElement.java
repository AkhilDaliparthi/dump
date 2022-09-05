package priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {

    public int solution(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k+1);
        for(int i:nums) {
            q.add(i);
            if(q.size()>k) {
                q.poll();
            }
        }
        return q.poll();
    }

    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement();
        System.out.println(kthLargestElement.solution(new int[]{3,2,1,5,6,4}, 2));
    }
}
