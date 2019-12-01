package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2019/12/1 10:22
 **/
public class week165 {
    public static void main(String[] args) {
//        int[][] nums = new int[][]{{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};
//        System.out.println(tictactoe(nums));

        System.out.println(numOfBurgers(17,4));
    }

    // 1
    private static int[] func;
    public static String tictactoe(int[][] moves) {
        int[][] nums = new int[3][3];
        func = new int[]{0,-1,0,1,1,0,-1,0,-1,-1,1,1,-1,1,1,-1};
        for (int i = 0; i <moves.length ; i++) {
            int x = moves[i][0];
            int y = moves[i][1];
            if(i%2==0){
                nums[x][y] = 1;
            }
            else{
                nums[x][y] = -1;
            }
        }
        for (int i = 0; i <nums.length ; i++) {
            for (int j = 0; j <nums.length ; j++) {
                if(nums[i][j] == 1 ) {
                    for (int k = 0; k <8 ; k++) {
                        if(dfs(nums,1,1,i,j,k)) return "A";
                    }

                }
                if(nums[i][j] == -1 ) {
                    for (int k = 0; k <8 ; k++) {
                        if(dfs(nums,1,-1,i,j,k)) return "B";
                    }
                }
            }
        }
        if(moves.length == 9) return "Draw";
        else return "Pending";

    }
    public static boolean dfs(int[][] nums,int count,int last,int x,int y,int index){
        if(x<0||x>=3||y<0||y>=3) return false;
        if(last != nums[x][y]) return false;
        if (count == 3) return true;
        return dfs(nums,count+1,last,x+func[2*index],y+func[2*index+1],index);
    }

    //2
    public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        int count_a = 0,count_b = 0;
        List<Integer> res = new ArrayList<>();
        if(tomatoSlices %2 == 0){
            int a = tomatoSlices/2-cheeseSlices;
            int b = cheeseSlices - a;
            if(a>=0 && b>=0){
                res.add(a);
                res.add(b);
            }
        }
        return res;
    }

    // 3



    // 4

}
