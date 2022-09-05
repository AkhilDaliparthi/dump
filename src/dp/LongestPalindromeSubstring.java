package dp;

public class LongestPalindromeSubstring {

    public int recSolution(String str) {
        return recSol(str, 0, str.length()-1);
    }

    public int recSol(String str, int low, int high) {
        if(isPalindrome(str, low, high)) {
            return (high-low)+1;
        }
        return Math.max(recSol(str, low+1, high), recSol(str, low, high-1));
    }

    public boolean isPalindrome(String str, int low, int high) {
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
        if(isPalindrome(str, low, high)) {
            dp[low][high] = (high-low)+1;
        }
         return dp[low][high] = Math.max(topDownRec(str, low+1, high, dp), topDownRec(str, low, high-1, dp));
    }

    public int bottomUp(String str) {
        int max = 0;
        boolean[][] dp = new boolean[str.length()+1][str.length()+1];
        for(int i=0; i<str.length(); i++) {
            dp[i][i] = true;
            max = 1;
        }
        for(int i=0; i+1<str.length(); i++) {
            if(str.charAt(i)==str.charAt(i+1)) {
                dp[i][i+1] = true;
                max = 2;
            }
        }
        for(int len=3; len<str.length(); len++) {
            for(int i=0; i+len-1<str.length(); i++) {
                int j=i+len-1;
                if(str.charAt(i)==str.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j]=true;
                    if(max<j-i+1) {
                        max = j-i+1;
                    }
                }
            }
        }
        return max;
    }

    public int simpleSolution(String s) {
        int max = 0;
        for(int i=0; i<s.length(); i++) {
            int p = getPalindrome(s, i, i);
            if(max<p) {
                max = p;
            }
            p = getPalindrome(s, i, i+1);
            if(max<p) {
                max = p;
            }
        }
        return max;
    }

    public int getPalindrome(String s, int start, int end) {
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)) {
            start--;
            end++;
        }
        return end-start+1;
    }

    public static void main(String[] args) {
        LongestPalindromeSubstring longestPalindromeSubstring = new LongestPalindromeSubstring();
        System.out.println(longestPalindromeSubstring.simpleSolution("forgeeksskeegfor"));
    }
}
