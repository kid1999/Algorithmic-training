package LeetCode;

/**
 * @auther: kid1999
 * @date: 2019/12/18 3:40
 * @desc: P59
 **/
public class P59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1;
        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};
        int i = 0,j = 0,index = 0;
        while(num < n*n){
            if(res[i][j] == 0){
                res[i][j] = num;
                num++;
            }
            int new_i = i+dx[index];
            int new_j = j+dy[index];
            while(new_i <0 || new_i >= n || new_j <0 || new_j>=n || res[new_i][new_j] != 0){
                index = (index+1)%4;
                new_i = i+dx[index];
                new_j = j+dy[index];
            }
            i = new_i;
            j = new_j;
        }
        res[i][j] = num;
        return res;
    }
}
