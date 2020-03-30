package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/3/30 11:50
 **/
public class P695 {
    public static void main(String[] args) {

    }


    static int[] func;
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        func = new int[]{-1,0,0,1,1,0,0,-1};
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                if(grid[i][j] == 1){
                    int sum = dfs(grid,i,j);
                    if(sum>res) res = sum;
                }
            }
        }
        return res;
    }
    public static int dfs(int[][] grid,int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        int sum = 1;
        for (int k = 0; k <4 ; k++) {
            sum += dfs(grid,i+func[2*k],j+func[2*k+1]);
        }
        return sum;
    }
}
