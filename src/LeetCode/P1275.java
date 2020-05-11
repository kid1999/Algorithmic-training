package LeetCode;

import java.util.Map;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/11 9:35
 **/
public class P1275 {
    public static void main(String[] args) {

    }

    // 因为9宫格小 所以直接使用二进制表示A|B占领某一位
    // 如果n为1的位与a相同则  a & n == n
    public String tictactoe(int[][] moves) {
        int a = 0,b = 0;
        for (int k = 0;k<moves.length;k++) {
            int i = moves[k][0],j = moves[k][1];
            if(k%2 == 0) a += Math.pow(2,(i*3+j));
            else b += Math.pow(2,(i*3+j));
        }
        // 8 种获胜状态
        int[] check = {448, 56, 7, 292, 146, 73, 273, 84};
        for (int n:check) {
            if((a&n) == n) return "A";
            else return "B";
        }
        if(moves.length == 9) return "Draw";
        return "Pending";
    }



    // dfs
//    private static int[] func;
//    public static String tictactoe(int[][] moves) {
//        int[][] nums = new int[3][3];
//        func = new int[]{0,-1,0,1,1,0,-1,0,-1,-1,1,1,-1,1,1,-1};
//        for (int i = 0; i <moves.length ; i++) {
//            int x = moves[i][0];
//            int y = moves[i][1];
//            if(i%2==0){
//                nums[x][y] = 1;
//            }
//            else{
//                nums[x][y] = -1;
//            }
//        }
//        for (int i = 0; i <nums.length ; i++) {
//            for (int j = 0; j <nums.length ; j++) {
//                if(nums[i][j] == 1 ) {
//                    for (int k = 0; k <8 ; k++) {
//                        if(dfs(nums,1,1,i,j,k)) return "A";
//                    }
//
//                }
//                if(nums[i][j] == -1 ) {
//                    for (int k = 0; k <8 ; k++) {
//                        if(dfs(nums,1,-1,i,j,k)) return "B";
//                    }
//                }
//            }
//        }
//        if(moves.length == 9) return "Draw";
//        else return "Pending";
//
//    }
//    public static boolean dfs(int[][] nums,int count,int last,int x,int y,int index){
//        if(x<0||x>=3||y<0||y>=3) return false;
//        if(last != nums[x][y]) return false;
//        if (count == 3) return true;
//        return dfs(nums,count+1,last,x+func[2*index],y+func[2*index+1],index);
//    }
}
