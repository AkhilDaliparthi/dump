package strings;

import arrays.ContainerWithMostWater;

import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int tempStart = 0;
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        for(int i=0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i)) && tempStart <= map.get(s.charAt(i))) {
                tempStart = map.get(s.charAt(i))+1;
            }
            map.put(s.charAt(i), i);
            if((i-tempStart)+1 > max) {
                max = (i-tempStart)+1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters LSWRC = new LongestSubstringWithoutRepeatingCharacters();
        System.out.print(LSWRC.lengthOfLongestSubstring("bbbbb"));
    }
}
