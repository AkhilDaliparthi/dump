package udemy.arrays;

import com.sun.tools.javac.util.Pair;

public class SubarraySort {

    public Pair<Integer, Integer> solution(int[] a) {
        int max = 0;
        int min = 0;
        for(int i=0; i<a.length-1; i++) {
            if(a[i+1]<a[i] || a[i]<a[i-1]) {
               if(a[i]>a[max]) {
                   max = i;
               }
               if(a[i]<a[min]) {
                   min = i;
               }
            }
        }
        int i=0;
        while(a[i]<a[min]) {
            i++;
        }
        int j=a.length-1;
        while(a[j]>a[max]) {
            j--;
        }
        return new Pair<>(i,j);
    }

    public static void main(String[] args) {
        SubarraySort subarraySort = new SubarraySort();
        int[] input = {1,2,3,4,5,8,6,7,9,10,11};
        Pair<Integer, Integer> res = subarraySort.solution(input);
        System.out.println(res.fst+"\t"+res.snd);
    }
}
