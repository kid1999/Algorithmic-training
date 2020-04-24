package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/24 8:55
 **/
public class PM51 {
    public static void main(String[] args) {

    }

    static int res;
    public int reversePairs(int[] nums) {
        res = 0;
        merage_sort(nums,0,nums.length-1);
        return res;
    }
    public static void merage_sort(int[] nums,int l,int r){
        if(l>=r) return;
        int mid = l + r >> 1;
        merage_sort(nums,l,mid);
        merage_sort(nums,mid+1,r);
        int[] temp = new int[r-l+1];
        int k=0,left=l,right=mid+1;
        while (left<=mid && right<=r){
            if(nums[left] < nums[right]){
                temp[k++] = nums[left++];
            }
            else{
                res += mid-left+1;
                temp[k++] = nums[right++];
            }
        }
        while (left<=mid) temp[k++] = nums[left++];
        while (right<=r) temp[k++] = nums[right++];
        for (int n:temp) nums[l++] = n;
    }
}
