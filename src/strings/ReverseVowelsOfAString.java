package strings;

//https://leetcode.com/problems/reverse-vowels-of-a-string/

public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int low = 0;
        int high = s.length()-1;
        while(low<high) {
            if(chars[low]=='a' || chars[low]=='e' || chars[low]=='i' || chars[low]=='o' || chars[low]=='u' ||
                    chars[low]=='A' || chars[low]=='E' || chars[low]=='I' || chars[low]=='O' || chars[low]=='U') {
                if(chars[high]=='a' || chars[high]=='e' || chars[high]=='i' || chars[high]=='o' || chars[high]=='u' ||
                        chars[high]=='A' || chars[high]=='E' || chars[high]=='I' || chars[high]=='O' || chars[high]=='U') {
                    if(chars[low] != chars[high]) {
                        char ch = chars[low];
                        chars[low] = chars[high];
                        chars[high] = ch;
                    }
                    low++;
                    high--;
                } else {
                    high--;
                }
            } else {
                low++;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString solution = new ReverseVowelsOfAString();
        System.out.print(solution.reverseVowels("aA"));
    }
}
