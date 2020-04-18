package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/18 11:05
 **/
public class P11 {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int res = 0;
        int l = 0;
        int r =height.length-1;
        while (l<r){
            int h = Math.min(height[l],height[r]);
            res = Math.max(res, h*(r-l));
            if(height[l] < height[r]) l++;
            else r--;
        }
        return res;
    }
}
