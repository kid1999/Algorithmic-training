package LeetCode;

public class P79 {
  public static void main(String[] args) {

  }

  public boolean exist(char[][] board, String word) {
    for (int i = 0; i <board.length ; i++) {
      for (int j = 0; j <board[0].length ; j++) {
        if(board[i][j] == word.charAt(0)){
          if (dfs(board,i,j,word,0)) return true;
        }
      }
    }
    return false;
  }

  public static boolean dfs(char[][] board,int i,int j,String word,int cur){
    if(cur == word.length()) return true;
    if(i<0||i>=board.length||j<0||j>=board[0].length  || board[i][j]!=word.charAt(cur)) return false;
    char tmp = board[i][j];
    board[i][j] = '0';
    boolean res = dfs(board, i+1, j, word, cur+1) ||
            dfs(board, i-1, j, word, cur+1) ||
            dfs(board, i, j+1, word, cur+1) ||
            dfs(board, i, j-1, word, cur+1);
    board[i][j] = tmp;
    return res;
  }

}
