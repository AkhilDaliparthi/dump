package backtracking;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j]==word.charAt(0)) {
                    if(wordExist(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean wordExist(char[][] board, String word, int index, int m, int n) {
        if(m<0 || m>=board.length || n<0 || n>=board[0].length) {
            return false;
        }
        if(index>=word.length()) {
            return true;
        }
        char temp = board[m][n];
        if(board[m][n]==word.charAt(index)) {
            board[m][n] = '#';
            return wordExist(board, word, index+1, m+1, n) || wordExist(board, word, index+1, m-1, n)
                    || wordExist(board, word, index+1, m, n+1) || wordExist(board, word, index+1, m, n-1);
        }
        board[m][n] = temp;
        return false;
    }

    public static void main (String[] args) {
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
    }
}
