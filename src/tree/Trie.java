package tree;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    Node root;

    Trie() {
        this.root = new Node();
        this.root.child = new HashMap<>();
    }

    class Node {
        Character ch;
        Map<Character, Node> child;

        Node() {}
        Node(Character ch) {
            this.ch = ch;
            this.child = new HashMap<>();
        }
    }

    public void addWords(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            if(!curr.child.containsKey(word.charAt(i))) {
                Node temp = new Node(word.charAt(i));
                curr.child.put(word.charAt(i), temp);
            }
            curr = curr.child.get(word.charAt(i));
        }
    }

    public boolean searchWord(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            if(!curr.child.containsKey(word.charAt(i))) {
                return false;
            }
            curr = curr.child.get(word.charAt(i));
        }
        return true;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addWords("Akhil");
        trie.addWords("Eswar");
        System.out.println(trie.searchWord("Eswa"));
    }
}
