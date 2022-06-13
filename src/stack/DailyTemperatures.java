package stack;

import java.util.Stack;

public class DailyTemperatures {

    public int[] solution(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i=0; i<temperatures.length; i++) {
            if(st.empty()) {
              st.push(i);
            } else {
                if(st.peek()>=temperatures[i]) {
                    st.push(i);
                } else {
                    while (!st.empty() && temperatures[st.peek()]<temperatures[i]) {
                        int top = st.pop();
                        res[top] = i-top;
                    }
                    st.push(i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] res = dailyTemperatures.solution(new int[]{73,74,75,71,69,72,76,73});
        for(int i:res) {
            System.out.print(i+"\t");
        }
    }
}
