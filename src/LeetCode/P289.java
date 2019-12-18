package LeetCode;

/**
 * @auther: kid1999
 * @date: 2019/12/18 17:08
 * @desc: P289
 **/
public class P289 {
    public void gameOfLife(int[][] board) {
        int x_len = board.length;
        int y_len = board[0].length;
        int[][] arr = new int[x_len][y_len];
        int[] x = {-1,-1,-1,0,0,1,1,1};
        int[] y = {-1,0,1,-1,1,-1,0,1};
        for (int i = 0; i <x_len ; i++) {
            for (int j = 0; j <y_len ; j++) {
                int count = 0;
                for (int k = 0; k <8 ; k++) {
                    if(i+x[k] < 0 || i+x[k] >=x_len || j+y[k]<0 || j+y[k]>=y_len) continue;
                    if(board[i+x[k]][j+y[k]] == 1) count++;
                }
                if(board[i][j] == 0){
                    if(count == 3) arr[i][j] = 1;
                    else arr[i][j] = 0;
                }else {
                    if(count < 2 || count > 3) arr[i][j] = 0;
                    else arr[i][j] = 1;
                }
            }
        }
        for (int i = 0; i <x_len ; i++) {
            for (int j = 0; j <y_len ; j++) {
                board[i][j] = arr[i][j];
            }
        }
    }
}
