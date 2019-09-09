package sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5,9,3,7,6,4,2,1,8};
        for (int n:nums) {
            System.out.print(n + " ");
        }
        System.out.println();
        sort(nums,0,nums.length-1);

        for (int n:nums) {
            System.out.print(n + " ");
        }

    }

    // sort
    private static void sort(int[] nums,int L, int R){
        if(L>=R) return;    // 递归出口
        int j = partation(nums,L,R);    // 一次分区
        sort(nums,L,j-1);   // 左分区 向左边逼近
        sort(nums,j+1,R);   // 右分区 向右边逼近
    }

    private static int partation(int[] nums,int L,int R){
        int aim = nums[L];
        int low = L;
        int high = R+1;
        int tmp;
        while(true){
            while (++low <= R) if (nums[low] >= aim) break;     //从左往右 选到比标兵大的就停止
            while (--high >=L) if (nums[high] <= aim) break;    //从右往左 选到比标兵小的就停止
            if(low>=high) break;    // 循环出口
            {                       // 交换大 小的数据
                tmp = nums[high];
                nums[high] = nums[low];
                nums[low] = tmp;
            }
        }
        // 最后将 标兵与high的值进行交换
        tmp = nums[high];
        nums[high] = nums[L];
        nums[L] = tmp;
        return high;

    }

}
