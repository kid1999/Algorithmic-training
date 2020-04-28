package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/28 10:36
 **/
public class P494 {

    // dp
    /**
     * sum(P) 前面符号为+的集合；sum(N) 前面符号为减号的集合
     * 所以题目可以转化为
     * sum(P) - sum(N) = target
     * => sum(nums) + sum(P) - sum(N) = target + sum(nums)
     * => 2 * sum(P) = target + sum(nums)
     * => sum(P) = (target + sum(nums)) / 2
     */
    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length;
        int sum = 0;
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        for (int i = 0; i <len ; i++) sum += nums[i];
        int weight = (sum+S)/2;

        int[] dp = new int[weight+1];
        dp[0] = 1;
        for (int i = 0; i <len ; i++) {
            for (int j = weight; j >=nums[i] ; j--) {
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[weight];
    }

    // dfs 搜索
//    int res = 0;
//    public int findTargetSumWays(int[] nums, int S) {
//        DFS(nums,S,0,0);
//        return res;
//    }
//    public void DFS(int[] nums,int S,int tmp,int index){
//        if(index == nums.length){
//            res = S == tmp ? ++res : res;
//            return;
//        }
//        DFS(nums,S,tmp + nums[index],index+1);
//        DFS(nums,S,tmp - nums[index],index+1);
//    }

}
