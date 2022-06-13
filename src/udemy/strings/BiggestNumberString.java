package udemy.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BiggestNumberString {

    public String solution(List<Integer> numbers) {
        String result = "";
        numbers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String xy = o1.toString()+o2.toString();
                String yx = o2.toString()+o1.toString();
                return xy.compareTo(yx) > 0 ? -1:1;
            }
        });
        for (Integer i : numbers) {
            result+=i.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        BiggestNumberString biggestNumberString = new BiggestNumberString();
        System.out.println(biggestNumberString.solution(Arrays.asList(10,11,20,30,3)));
    }
}
