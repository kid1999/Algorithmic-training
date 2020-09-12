package LeetCode.protest2020;

import java.util.Arrays;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/25 15:00
 **/
public class ContestSpringTerm {


//    public int expectNumber(int[] scores) {
//
//    }


    // 2
//    public int minTime(int[] time, int m) {
//        int len = time.length;
//        if(m>=len) return 0;
//        int[][] dp = new int[m+1][len+1];
//        for (int i = 1; i <=m ; i++) {
//            for (int j = 1; j <=len ; j++) {
//                dp[i][j] = dp[i][j-1] + time[j-1];
//                dp[i][j] = Math.min(dp[i][j],dp[i-1][j]);
//            }
//        }

//    }

    public static void main(String[] args) {
        int[] arr = {2,2,1,2,3};
        System.out.println(splitArray(arr));
    }



    // 4
    public static int splitArray(int[] nums) {
        int count = 0;
        int l = 0,r = nums.length;
        while (l<r) {
            if(nums[l] == 1) return 0;
            int index = l;
            for (int i = l; i <r; i++) {
                if(i==r-1){
                    if(gcd(nums[l],nums[i]) > 1){
                        index = i;
                    }
                }else{
                    if(gcd(nums[l],nums[i]) > 1){
                        if(nums[i+1] != 1) index = i;
                    }
                }
            }
            l = index+1;
            count++;
        }
        return count;
    }

    public static int gcd(int x,int y){
        if(x>y){
            int tmp = x;
            x = y;
            y = tmp;
        }
        return x == 0 ? y : gcd(y%x,x);
    }

}
