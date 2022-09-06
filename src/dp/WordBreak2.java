package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class WordBreak2 {
    HashSet<String> set = new HashSet<>();
    public List<String> recSolution(String s, List<String> words) {
        List<String> res = new ArrayList<>();
        set.addAll(words);
        recursion(s, 0, res, "");
        return res;
    }

    public void recursion(String s, int start, List<String> res, String possibleStr) {
        if(start==s.length()) {
            res.add(possibleStr.substring(1));
        }
        for(int i=start; i<s.length(); i++) {
            String word = s.substring(start, i+1);
            if(set.contains(word)) {
                recursion(s, i+1, res, possibleStr+" "+word);
            }
        }
    }

    ArrayList<ArrayList<String>> dp;
    public ArrayList<String> wordBreak(String A,  List<String> B) {
        dp = new ArrayList<ArrayList<String>>();
        for(int i = 0;i<A.length();i++){
            dp.add(new ArrayList<String>());
        }
        HashSet<String> set = new HashSet<>();
        for(String str:B){
            set.add(str);
        }
        return wordBreak(A,set,0);
    }
    public ArrayList<String> wordBreak(String A, HashSet<String> set, int i) {
        if(i==A.length()){
            return new ArrayList<String>();
        }
        if(dp.get(i).size()!=0 )
            return dp.get(i);
        ArrayList<String> ans = new ArrayList<>();
        for(int j = i+1;j<=A.length();j++){
            if(set.contains(A.substring(i,j))){
                ArrayList<String> buf = wordBreak(A,set,j);
                for(String a: buf){
                    ans.add(A.substring(i,j)+" "+a);
                }
                if(j==A.length()){
                    ans.add(A.substring(i));
                }
            }
        }
        dp.set(i,ans);
        return ans;
    }

    public static void main(String[] args) {
        WordBreak2 wordBreak2 = new WordBreak2();
        List<String> res = wordBreak2.wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog"));
        for(String s : res) {
            System.out.println(s);
        }
    }
}
