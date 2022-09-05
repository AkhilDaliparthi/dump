package strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {

    public int solution(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> s = new HashSet<>(wordList.size());
        for(String word : wordList) {
            s.add(word);
        }
        if(!s.contains(endWord)) {
            return 0;
        }
        if(s.contains(beginWord)) {
            s.remove(beginWord);
        }
        int res = 1;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        while(!q.isEmpty()) {
            Queue<String> temp = new LinkedList<>();
            while(!q.isEmpty()) {
                String word = q.remove();
                String newWord = word;
                for(int index=0; index<word.length(); index++) {
                    newWord = word;
                    StringBuilder sb = new StringBuilder(newWord);
                    char ch = 'a';
                    for(int i=0; i<26; i++) {
                        sb.setCharAt(index, (char) (ch+i));
                        newWord = sb.toString();
                        if(s.contains(newWord) && !newWord.equals(word)) {
                            if(newWord.equals(endWord)) {
                                return res+1;
                            }
                            s.remove(newWord);
                            temp.add(newWord);
                        }
                    }
                }
            }
            q = temp;
            res++;
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        System.out.println(wordLadder.solution("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
}
