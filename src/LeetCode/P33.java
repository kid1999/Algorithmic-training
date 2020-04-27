package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/27 8:35
 **/
public class P33 {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l<r){
            int mid = l+r>>1;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < nums[r]){
                if(nums[mid] < target && target <= nums[r]) l = mid+1;
                else r = mid-1;
            }else {
                if(nums[l] <= target && target < nums[mid]) r = mid-1;
                else l = mid+1;
            }
        }
        return -1;
    }
}
