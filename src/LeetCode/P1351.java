package LeetCode;

/**
 * @auther: kid1999
 * @desc:
 * @date: 2020/8/17 19:06
 **/
public class P1351 {

    public int countNegatives(int[][] grid) {
        int res = 0;
        for(int[] arr:grid){
            int l = 0,r = arr.length-1;
            while (l < r){
                int mid = l + r >> 1;
                if(arr[mid] < 0) r = mid;
                else l = mid + 1;
            }
            if(arr[l] < 0) res += (arr.length-l);
        }
        return res;
    }
}
