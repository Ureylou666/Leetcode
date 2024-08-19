public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        boolean[][] check = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == words[0]) {
                    for (int m = 0 ; m < board.length; m++)
                        for (int n=0; n < board[0].length; n++) check[m][n] = false;
                   if (explore(board,check,i,j,word,0)) return true;
                }
            }
        }
        return false;
    }

    public static boolean explore(char[][] board, boolean[][] check ,int i, int j, String word,int n) {
        if (n >= word.length()) return true;
        if (i<0 || j <0 || i >= board.length || j >= board[0].length || check[i][j]) return false;
        if (board[i][j] != word.charAt(n) ) return false;
        check[i][j] = true;
        boolean result = ( explore(board,check,i+1,j,word,n+1) || explore(board,check,i-1,j,word,n+1) || explore(board,check,i,j+1,word,n+1) || explore(board,check,i,j-1,word,n+1) );
        if (!result) {
            check[i][j] = false;
        }
        return result;
    }
}
