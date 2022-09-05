package backtracking;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for(String word : words) {
            if(checkWord(board, word)){
                res.add(word);
            }
        }
        return res;
    }

    private boolean checkWord(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]==word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if(isPresent(board, i, j, 0, word, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isPresent(char[][] board, int i, int j, int index, String word, boolean[][] visited) {
        if(index==word.length()) {
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        if(isPresent(board, i+1, j, index+1, word, visited) || isPresent(board, i-1, j, index+1, word, visited)
                || isPresent(board, i, j+1, index+1, word, visited) || isPresent(board, i, j-1, index+1, word, visited)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        WordSearch2 wordSearch2 = new WordSearch2();
        List<String> res = wordSearch2.findWords(new char[][]{{'A','B',}}, new String[] {"BA"});
        for(String word : res) {
            System.out.println(word);
        }
    }
}
