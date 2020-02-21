package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/2/21 19:17
 **/
public class P130 {
    public static void main(String[] args) {

    }

//  方法一： 通过dfs暴力遍历
    public static void solve(char[][] board) {
        if(board==null||board.length==0) return ;
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                // 从边缘o开始搜索
                boolean flag = i==0||j==0||i==board.length-1||j==board[0].length-1;
                if(flag && board[i][j] == 'O') dfs(board,i,j);
            }
        }
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'N') board[i][j] = 'O';
            }
        }
    }
    public static void dfs(char[][] board,int i,int j){
        if(i<0||j<0||i>=board.length||j>=board[0].length || board[i][j]!='O') return ;
        board[i][j] = 'N';
        dfs(board, i - 1, j); // 上
        dfs(board, i + 1, j); // 下
        dfs(board, i, j - 1); // 左
        dfs(board, i, j + 1); // 右
    }



}


