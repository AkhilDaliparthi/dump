package dp;

public class RodCutting {

    public int recSolution(int[] rodArray, int len) {
        if(len==0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<rodArray.length; i++) {
            if(len>i) {
                int temp = recSolution(rodArray, len-i-1);
                if(temp+rodArray[i]>max && temp != Integer.MIN_VALUE) {
                    max = temp+rodArray[i];
                }
            }
        }
        return max;
    }

    public int solution(int[] rodArray, int len) {
        int[] dp = new int[len+1];
        for(int i=1; i<dp.length; i++) {
            dp[i] = Integer.MIN_VALUE;
            for(int j=0; j<rodArray.length; j++) {
                if(i>j) {
                    int temp = dp[i-j-1] + rodArray[j];
                    if(temp>dp[i] && temp != Integer.MIN_VALUE) {
                        dp[i] = temp;
                    }
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        RodCutting rodCutting = new RodCutting();
        int rodArray[] = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(rodCutting.solution(rodArray, 8));
        System.out.println(rodCutting.recSolution(rodArray, 8));
    }
}
