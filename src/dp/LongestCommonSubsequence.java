package dp;

public class LongestCommonSubsequence {

    public int recSolution(String text1, String text2) {
        return recursion(0,0, text1, text2);
    }

    private int recursion(int i, int j, String s1, String s2) {
        if(i>=s1.length() || j>=s2.length()) {
            return 0;
        }
        if(s1.charAt(i)==s2.charAt(j)) {
            return 1+recursion(i+1, j+1, s1, s2);
        }
        return Math.max(recursion(i+1, j, s1, s2), recursion(i, j+1, s1, s2));
    }

    public int solution(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i=0; i<text1.length(); i++) {
            for(int j=0; j<text2.length(); j++) {
                if(text1.charAt(i)==text2.charAt(j)) {
                    dp[i][j] = (i==0 || j==0) ? 1 : dp[i-1][j-1]+1;
                } else {
                    if(i>0 && j>0) {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    } else {
                        if(i>0 || j>0) {
                            dp[i][j] = i>0 ? dp[i-1][j] : dp[i][j-1];
                        }
                    }
                }
            }
        }
        return dp[text1.length()-1][text2.length()-1];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.solution("abc", "abc"));
    }
}
