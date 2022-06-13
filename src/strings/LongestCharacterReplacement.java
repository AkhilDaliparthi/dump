package strings;

public class LongestCharacterReplacement {

    public int solution(String s, int k) {
        int[] ch = new int[26];
        int start = 0;
        int res = 0;
        int max = 0;
        for(int end=0; end<s.length(); end++) {
            ch[s.charAt(end)-'A']++;
            max = Math.max(max, ch[s.charAt(end)-'A']);
            while(end-start-max+1>k) {
                ch[s.charAt(start)-'A']--;
                start++;
            }
            res = Math.max(end-start+1, res);
        }
        return res;
    }

    public static void main(String[] args) {
        LongestCharacterReplacement longestCharacterReplacement = new LongestCharacterReplacement();
        System.out.print(longestCharacterReplacement.solution("AABABBA", 1));
    }
}
