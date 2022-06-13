package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {

    public String solution(String[] words) {
        Map<Character, Set<Character>> g = new HashMap<>();
        int[] inDegree = new int[26];
        buildGraph(words, g, inDegree);
        return bfs(g, inDegree);
    }

    private String bfs(Map<Character, Set<Character>> g, int[] inDegree) {
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(Character ch : g.keySet()) {
            if(inDegree[ch-'a']==0) {
                q.add(ch);
                sb.append(ch);
            }
        }
        while(!q.isEmpty()) {
            Character ch = q.poll();
            for(Character next : g.get(ch)) {
                inDegree[next-'a']--;
                if(inDegree[next-'a']==0) {
                    q.add(next);
                    sb.append(next);
                }
            }
        }
        return sb.length()==g.size() ? sb.toString() : "";
    }

    private void buildGraph(String[] words, Map<Character, Set<Character>> g, int[] inDegree) {
        for(String word : words) {
            for(Character ch : word.toCharArray()) {
                g.putIfAbsent(ch, new HashSet<>());
            }
        }
        for(int i=1; i<words.length; i++) {
            String first = words[i-1];
            String second = words[i];
            int len = Math.min(first.length(), second.length());
            for(int j=0; j<len; j++) {
                if(first.charAt(j)!=second.charAt(j)) {
                    Character out = first.charAt(j);
                    Character in = second.charAt(j);
                    if(!g.get(out).contains(in)) {
                        g.get(out).add(in);
                        inDegree[in-'a']++;
                    }
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        System.out.print(alienDictionary.solution(new String[]{"wrt","wrf","er","ett","rftt"}));
    }
}
