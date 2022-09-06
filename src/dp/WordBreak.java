package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> set = new HashSet<>(wordDict);
        return helper(0, n, s, set);
    }

    public boolean helper(int pos, int n, String s, HashSet<String> set){
        if(pos>=n) return true;
        for(int i=pos+1;i<=n;i++){
            if(set.contains(s.substring(pos, i)) && helper(i, n, s, set)){
                return true;
            }
        }
        return false;
    }

    public Boolean topDown(String s, List<String> words) {
        Boolean[] dp = new Boolean[s.length()];
        HashSet<String> set = new HashSet<>(words);
        return topDownRecursion(0, s, set, dp);
    }

    public Boolean topDownRecursion(int cur, String str, HashSet<String> set, Boolean[] dp) {
        if(cur == str.length())
            return true;
        if(dp[cur]!= null){
            return dp[cur];
        }
        boolean res = false;
        for(int i=cur;i< str.length();i++){
            String curStr = str.substring(cur,i+1);
            if(set.contains(curStr) && topDownRecursion(i+1,str,set,dp)){
                res = true;
            }
        }
        dp[cur]= res;
        return res;
    }

    public boolean bottomUp(String s, List<String> words) {
        boolean[] dp = new boolean[s.length()+1];
        HashSet<String> set = new HashSet<>(words);
        dp[0] = true;
        for(int i=1; i<=s.length(); i++) {
            for(int j=0; j<i; j++) {
                if(set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.bottomUp("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }
}
