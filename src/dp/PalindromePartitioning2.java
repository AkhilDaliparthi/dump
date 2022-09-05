package dp;

import java.util.Arrays;

public class PalindromePartitioning2 {

    int mincut = Integer.MAX_VALUE;
    public int recSolution(String A) {
        return recursionSolution(0, A)-1;
    }

    public int recursionSolution(int start, String A) {
        if(start>=A.length()) {
            return 0;
        }
        for(int end=start; end<A.length(); end++) {
            if(isPalindrome(A, start, end)) {
                mincut = Math.min(mincut, 1+recursionSolution(end+1, A));
            }
        }
        return mincut;
    }

    private boolean isPalindrome(String A, int start, int end) {
        while(start<end) {
            if(A.charAt(start)!=A.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public int topBottom(String s) {
        int n = s.length();
        boolean[][] table = new boolean[n][n];
        for(int i=0; i<n; i++) {
            table[i][i] = true;
        }
        for(int i=0; i<n-1; i++) {
            if(s.charAt(i)==s.charAt(i+1)) {
                table[i][i+1] = true;
            }
        }
        for(int len=3; len<n; len++) {
            for(int i=0; i<n-len+1; i++) {
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j) && table[i+1][j-1]) {
                    table[i][j] = true;
                }
            }
        }
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        topBottomRec(s, 0, dp, table);
        return dp[n-1];
    }

    public int topBottomRec(String A, int start, int[] dp, boolean[][] table) {
        if(start>=A.length()) {
            return 0;
        }
        if(dp[start] != -1) {
            return dp[start];
        }
        int minCuts = Integer.MAX_VALUE;
        for(int end=start; end<A.length(); end++) {
            if(table[start][end]) {
                minCuts = Math.min(minCuts, 1+topBottomRec(A, end+1, dp, table));
            }
        }
        dp[start] = minCuts;
        return dp[start];
    }

    public static void main(String[] args) {
        PalindromePartitioning2 palindromePartitioning2 = new PalindromePartitioning2();
        System.out.println(palindromePartitioning2.topBottom("bb"));
    }
}
