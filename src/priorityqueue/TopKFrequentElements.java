package priorityqueue;

import java.util.HashMap;
import java.util.PriorityQueue;

//https://leetcode.com/problems/top-k-frequent-elements/

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((e1,e2) -> frequencyMap.get(e1) - frequencyMap.get(e2));
        for(int i : nums) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i,0)+1);
        }
        for(int i : frequencyMap.keySet()) {
            queue.add(i);
            if(queue.size()>k) {
                queue.poll();
            }
        }
        for(int i=0; i<k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements topk = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,4,4,4,4};
        int[] res = topk.topKFrequent(nums, 2);
        for(int i : res) {
            System.out.print(i+"\t");
        }
    }
}
