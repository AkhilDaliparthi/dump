package priorityqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Reorganise {

    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());

        Map.Entry<Character, Integer> previousEntry = null;
        StringBuilder sb = new StringBuilder(s.length());

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();

            if (previousEntry != null && previousEntry.getValue() > 0) {
                maxHeap.offer(previousEntry);
            }

            sb.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            previousEntry = currentEntry;
        }

        return sb.toString().length() == s.length() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        Reorganise reorganise = new Reorganise();
        System.out.println(reorganise.reorganizeString("aaabc"));
    }
}
