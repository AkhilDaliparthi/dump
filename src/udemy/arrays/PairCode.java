package udemy.arrays;

import java.util.HashSet;

public class PairCode {

    public int[] solution(int[] input, int sum ){
        HashSet<Integer> set = new HashSet<>(input.length);
        int[] res = new int[2];
        for(int num : input) {
            if(set.contains(sum-num) && !set.contains(num)) {
                res[0] = sum-num;
                res[1] = num;
                return res;
            }
            set.add(num);
        }
        return res;
    }

    public static void main (String[] args) {
        PairCode pairCode = new PairCode();
        int[] input = {10,5,2,3,-6,9,11};
        int[] res = pairCode.solution(input, 4);
        System.out.println(res[0]+"\t"+res[1]);
    }
}
