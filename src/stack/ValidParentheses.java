package stack;

import java.util.Stack;

public class ValidParentheses {

    public boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length();i++) {
            Character ch = s.charAt(i);
            if(ch =='(' || ch=='{' || ch =='[') {
                st.push(ch);
            } else {
                if(st.empty()) {
                    return false;
                } else {
                    if((st.peek()=='(' && ch ==')') || (st.peek()=='{' && ch =='}') || (st.peek()=='[' && ch ==']')) {
                        st.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return st.empty() ? true : false;
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.solution("()[]{}"));
    }
}
