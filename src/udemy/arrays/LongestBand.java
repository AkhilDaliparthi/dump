package udemy.arrays;

import java.util.HashSet;

public class LongestBand {

    public int[] solution(int[] a) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:a) {
            set.add(i);
        }
        int min = 0;
        int max = 0;
        for(int i:a) {
            int j=i;
            int k=i;
            if(i>max || i< min) {
                while(set.contains(k-1)) {
                    k--;
                }
                while(set.contains(j+1)){
                    j++;
                }
                if(j-k>max-min) {
                    min = k;
                    max = j;
                }
            }
        }
        int[] res = new int[max-min+1];
        for(int i = min, k=0; i<=max; i++, k++) {
            res[k] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        LongestBand longestBand = new LongestBand();
        int[] input = {1,9,0,3,18,5,2,4,10,7,12,6};
        int[] res = longestBand.solution(input);
        for(int i:res) {
            System.out.print(i+"\t");
        }
    }
}
