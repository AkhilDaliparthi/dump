package priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinNoOfPlatforms {

    public class Interval {
        int startTime;
        int endTime;
        Interval(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public int solution(int[] arr, int[] des) {
        ArrayList<Interval> intervals = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            intervals.add(new Interval(arr[i], des[i]));
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.startTime-o2.startTime;
            }
        });
        int count = 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(intervals.get(0).endTime);
        for(int i=1; i<intervals.size(); i++) {
            if(intervals.get(i).startTime<queue.peek()) {
                count++;
            } else {
                queue.poll();
            }
            queue.add(intervals.get(i).endTime);
        }
        return count;
    }

    public int findPlatform(int arr[], int dep[], int n) {
        // Sort arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);

        // plat_needed indicates number of platforms
        // needed at a time
        int plat_needed = 1, result = 1;
        int i = 1, j = 0;

        // Similar to merge in merge sort to process
        // all events in sorted order
        while (i < n && j < n) {
            // If next event in sorted order is arrival,
            // increment count of platforms needed
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            }

            // Else decrement count of platforms needed
            else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }

            // Update result if needed
            if (plat_needed > result)
                result = plat_needed;
        }

        return result;
    }

    public static void main(String[] args) {
        MinNoOfPlatforms minNoOfPlatforms = new MinNoOfPlatforms();
        int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
        int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };
        System.out.println(minNoOfPlatforms.solution(arr, dep));
    }
}
