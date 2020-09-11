package nowcoder.youzan;

/**
 * @author kid1999
 * @date 2020/9/11 14:51
 * @desc
 **/
public class Main {


    // 1
    public static long sum (int num, int itemNum) {
        // write code here
        long sum = 0;
        long n = 0;
        for (int i = 0; i <itemNum ; i++) {
            n = n*10 + num;
            sum += n;
        }
        return sum;
    }


    // 2
    public static int minMoves (int[] nums) {
        // write code here
        long sum = 0,len = nums.length;
        for (int n:nums) sum += n;
        long avg = sum / len;
        long avg2 = sum / len + 1;
        int dep = 0,dep2 = 0;
        for (int n:nums) {
            dep += Math.abs(n - avg);
            dep2 += Math.abs(n - avg2);
        }
        return Math.min(dep,dep2);
    }


    public static void main(String[] args) {
        int[] arr = {1,4,2};
        System.out.println(minMoves(arr));
    }



}
