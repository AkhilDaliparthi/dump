package dp;

public class LongestPallindromeSubstring {

    public int recSolution(String str) {
        return recSol(str, 0, str.length()-1);
    }

    public int recSol(String str, int low, int high) {
        if(isPallindrome(str, low, high)) {
            return (high-low)+1;
        }
        return Math.max(recSol(str, low+1, high), recSol(str, low, high-1));
    }

    public boolean isPallindrome(String str, int low, int high) {
        while(low<high) {
            if(str.charAt(low) != str.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public int topDown(String str){
        int[][] dp = new int[str.length()+1][str.length()+1];
        return topDownRec(str, 0, str.length()-1, dp);
    }

    public int topDownRec(String str, int low, int high, int[][] dp) {
        if(low>high) {
            return 0;
        }
        if(dp[low][high]>0) {
            return dp[low][high];
        }
        if(isPallindrome(str, low, high)) {
            dp[low][high] = (high-low)+1;
        }
         return dp[low][high] = Math.max(topDownRec(str, low+1, high, dp), topDownRec(str, low, high-1, dp));
    }

    public static void main(String[] args) {
        LongestPallindromeSubstring longestPallindromeSubstring = new LongestPallindromeSubstring();
        System.out.println(longestPallindromeSubstring.topDown("babad"));
    }
}
