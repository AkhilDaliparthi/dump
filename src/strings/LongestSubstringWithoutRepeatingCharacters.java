package strings;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        boolean[] charArray = new boolean[95];
        int low = 0;
        int high = 0;
        int res = 0;
        while(low<=high && high<s.length()) {
            char ch = s.charAt(high);
            if(charArray[ch-' ']) {
                charArray[s.charAt(low)-' '] = false;
                low++;
            } else {
                charArray[ch-' '] = true;
                if(res<high-low+1) {
                    res = high-low+1;
                }
                high++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.print(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew"));
    }
}
