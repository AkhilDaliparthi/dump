package hashtable;

//https://leetcode.com/problems/jewels-and-stones/

import java.util.HashSet;

public class JewelsAndStones {

    public int countJewels(String jewels, String stones) {
        int count = 0;
        HashSet<Character> jewelSet = new HashSet<>();
        for(int i=0; i<jewels.length(); i++) {
            jewelSet.add(jewels.charAt(i));
        }
        for(int i=0; i<stones.length(); i++) {
            if(jewelSet.contains(stones.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        JewelsAndStones jas = new JewelsAndStones();
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.print(jas.countJewels(jewels, stones));
    }
}
