package stack;

import java.util.Stack;

public class LargestRectangle {

    public int solution(int[] hist) {
        int max = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<hist.length; i++) {
            if(st.empty()) {
                st.push(i);
            } else {
                if(hist[st.peek()]<=hist[i]) {
                    st.push(i);
                } else {
                    while(!st.isEmpty() && hist[st.peek()]>hist[i]) {
                        int top = st.pop();
                        int area = hist[top] * (st.empty() ? i :(i-1-st.peek()));
                        if(area>max) {
                            max=area;
                        }
                    }
                    st.push(i);
                }
            }
        }
        while(!st.isEmpty()) {
            int top = st.pop();
            int area = hist[top] * (st.empty() ? hist.length :(hist.length-1-st.peek()));
            if(area>max) {
                max=area;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangle largestRectangle = new LargestRectangle();
        System.out.println(largestRectangle.solution(new int[]{2,4}));
    }
}
