package LeetCode;

/**
 * @author kid1999
 * @date 2020/8/30 10:14
 * @desc
 **/
public class week204 {

    // 1
    public static boolean containsPattern(int[] arr, int m, int count) {
        int len = arr.length;
        for (int i = 0; i <len-m ; i++) {
            int[] nums = new int[m];
            for (int k = 0; k <m ; k++) {
                nums[k] = arr[k+i];
            }
            int t = count;
            for (int k = i; k+m <=len ; k+=m) {
                boolean f = true;
                for (int j = 0; j <m ; j++) {
                    if(nums[j] != arr[k+j]) {
                        f = false;
                        break;
                    }
                }

                if(!f){
                    if(t <= 0) return true;
                    break;
                }else {
                    t--;
                    if(t <= 0) return true;
                }
            }
        }
        return false;
    }

    // 2
    public static int getMaxLen(int[] nums) {
        int res = 0;
        int z = 0,f = 0;
        for (int n:nums) {
            if(n == 0){
                z = 0;
                f = 0;
            }else if(n > 0){
                z++;
                if(f > 0) f++;
                res = Math.max(res,z);
            }else {
                int temp = z;
                z = f;
                f =temp;
                f++;
                if(z>0) z++;
                res = Math.max(res,z);
            }
        }
        return res;
    }



    // 3


    public static void main(String[] args) {
        int[] arr = {-1,-2,-3,0,1};
        System.out.println(getMaxLen(arr));
    }

}
