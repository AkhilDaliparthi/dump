package udemy.searchNsort;

import java.util.Arrays;
import java.util.Comparator;

public class SmallestWord {

    public String solution(String[] arr) {
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String x = o1+o2;
                String y = o2+o1;
                return x.compareTo(y);
            }
        });
        String res = "";
        for(String s:arr) {
            res+=s;
        }
        return res;
    }

    public static void main(String[] args) {
        SmallestWord smallestWord = new SmallestWord();
        String[] arr = {"a", "ab", "aba"};
        System.out.println(smallestWord.solution(arr));
    }
}
