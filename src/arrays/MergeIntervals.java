package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] solution(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        result.add(intervals[0]);
        for(int i=1; i<intervals.length; i++) {
            if(result.get(result.size()-1)[1]<intervals[i][0]) {
                result.add(intervals[i]);
            } else {
                int[] prev = result.remove(result.size()-1);
                result.add(new int[]{prev[0], Math.max(prev[1], intervals[i][1])});
            }
        }
        int[][] res = new int[result.size()][2];
        int i=0;
        for(int[] cur : result) {
            res[i][0] = cur[0];
            res[i][1] = cur[1];
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] res = mergeIntervals.solution(new int[][]{{1,4}, {2,3}});
        for(int i=0; i<res.length; i++) {
            System.out.println(res[i][0]+"\t"+res[i][1]);
        }
    }
}
