package udemy.arrays;

import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinSwaps {

    public int solution(int[] input) {
        int res = 0;
        List<Pair<Integer, Integer>> initial = new ArrayList<>();
        for(int i=0; i<input.length; i++) {
            initial.add(new Pair<>(input[i], i));
        }
        initial.sort(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.fst-o2.fst;
            }
        });
        boolean[] visited = new boolean[input.length];

        for(int i=0; i<input.length; i++) {
            int count = 0;
            while(!visited[i]) {
                count++;
                visited[i]=true;
                i = initial.get(i).snd;
            }
            if(count>0) res+=count-1;
        }
        return res;
    }

    public static void main(String[] args) {
        MinSwaps minSwaps = new MinSwaps();
        int[] input = {10,11,5,4,3,2,1};
        System.out.println(minSwaps.solution(input));
    }
}
