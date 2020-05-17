package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/17 9:44
 **/
public class P529 {
    public static void main(String[] args) {
        char[][] wods = {{'E', 'E', 'E', 'E', 'E'},
        {'E', 'E', 'M', 'E', 'E'},
        {'E', 'E', 'E', 'E', 'E'},
        {'E', 'E', 'E', 'E', 'E'}};

        updateBoard(wods,new int[]{3,0});
    }

     static int[] x_func;
    static int[] y_func;
    public static char[][] updateBoard(char[][] board, int[] click) {
        x_func = new int[]{-1,0,1};
        y_func = new int[]{-1,0,1};
        char word = board[click[0]][click[1]];
        if(word == 'M') board[click[0]][click[1]] = 'X';
        else if(word == 'E') dfs(board,click[0],click[1]);
        return board;
    }
    static int dfs(char[][] board, int i,int j){
        if(board[i][j] == 'M') return 1;
        System.out.println(i + " " + j);
        int count = 0;
        for (int a:x_func) {
            for (int b:y_func) {
                if(i+a<0||j+b<0||i+a>=board.length||j+b>=board[0].length) continue;
                count += board[i+a][b+j] == 'M' ? 1 : 0;
            }
        }
        if(count > 0) board[i][j] = (char)(count + '0');
        else {
            board[i][j] = 'B';
            for (int a:x_func) {
                for (int b:y_func) {
                    if(a == 0 && b== 0) continue;
                    if(i+a<0||j+b<0||i+a>=board.length||j+b>=board[0].length) continue;
                    if(board[i+a][j+b] == 'E') dfs(board,i+a,b+j);
                }
            }
        }
        return 0;
    }
}
