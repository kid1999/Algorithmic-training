package base;

/**
 * @desc 组合数
 * @author kid1999
 * @date 2020/6/19 10:55
 **/
public class Combination {
    public static void main(String[] args) {
        System.out.println(Combination(5,2));
    }



    //递归法
    private static int Combination(int n, int k) {
        if(k>n) return 0;
        else if(k==0||k==n) return 1;
        else return Combination(n-1, k)+Combination(n-1, k-1);
    }

    //记忆化
    static int[][] dp = new int[100001][3];
    private static int CombinationBetter(int n, int k) {
        if(k>n) return 0;
        else if(k==0||k==n) return 1;
        else return Combination(n-1, k)+Combination(n-1, k-1);
    }





}
