package companies.amazon;

import java.util.Stack;

public class One {

    public int solution(int[] A) {
        int res = 0, soFar = 0, mod = (int)1e9 + 7, len = A.length;
        Stack<Integer> st = new Stack<>();
        int[] sumArray = new int[len + 2];
        for (int i = 0; i <=len; ++i) {
            int curr = i < len ? A[i] : 0;
            soFar = (soFar + curr) % mod;
            sumArray[i + 1] = (soFar + sumArray[i]) % mod;
            while (!st.isEmpty() && A[st.peek()] > curr) {
                int prevMin = st.pop();
                int currMin = st.isEmpty() ? -1 : st.peek();
                long left = currMin < 0 ? sumArray[prevMin] : sumArray[prevMin] - sumArray[currMin], right = sumArray[i] - sumArray[prevMin];
                int l = prevMin - currMin, r = i - prevMin;
                res = (int)(res + (right * l - left * r) % mod * A[prevMin] % mod) % mod;
            }
            st.push(i);
        }
        return (res + mod) % mod;
    }

    public static void main(String[] args) {
        One one = new One();
        System.out.println(one.solution(new int[]{3,2,1,3}));
    }
}
