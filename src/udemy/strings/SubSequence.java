package udemy.strings;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {

    public void recSolution(String str, String sub, List<String> allStrings) {
        if(str.length()==0) {
            allStrings.add(sub);
            System.out.println(sub);
            return;
        }
        recSolution(str.substring(1), sub+str.charAt(0), allStrings);
        recSolution(str.substring(1), sub, allStrings);
    }

    public void solution(String str) {
        recSolution(str,"", new ArrayList<>());
    }

    public static void main(String[] args) {
        SubSequence subSequence = new SubSequence();
        subSequence.solution("abc");
    }
}
