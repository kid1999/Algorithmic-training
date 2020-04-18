package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/18 11:38
 **/
public class P72 {
    public static void main(String[] args) {

    }

    // 递归法： 超时
//    static int res;
//    public int minDistance(String word1, String word2) {
//        res = Integer.MAX_VALUE;
//        if(word1.length() == 0) return word2.length();
//        if(word2.length() == 0) return word1.length();
//        dfs(word1,word2,word1.length()-1,word2.length()-1,0);
//        return res;
//    }
//    public static void dfs(String word1, String word2,int i,int j,int dep){
//        if(i==-1 || j==-1){
//            if(i != -1) dep += i+1;
//            if(j != -1) dep += j+1;
//            if(dep < res) res = dep;
//            return;
//        }
//        if(word1.charAt(i) == word2.charAt(j)) dfs(word1,word2,i-1,j-1,dep);
//        else{
//            dfs(word1,word2,i,j-1,dep+1);   // 插入
//            dfs(word1,word2,i-1,j,dep+1);     // 删除
//            dfs(word1,word2,i-1,j-1,dep+1);     // 置换
//        }
//    }


    // dp 动态规划
    public int minDistance(String word1, String word2) {
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();
        int len1 = word1Array.length;
        int len2 = word2Array.length;
        // 多开一行一列是为了保存边界条件，即字符长度为 0 的情况，这一点在字符串的动态规划问题中比较常见
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 初始化：当 word 2 长度为 0 时，将 word1 的全部删除
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        // 当 word1 长度为 0 时，就插入所有 word2 的字符
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = j;
        }
        // 注意：填写 dp 数组的时候，由于初始化多设置了一行一列，横、纵坐标有个偏移
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                // 这是最佳情况
                if (word1Array[i] == word2Array[j]) {
                    dp[i + 1][j + 1] = dp[i][j];
                    continue;
                }
                // 否则在以下三种情况中选出步骤最少的，这是「动态规划」的「最优子结构」
                // 1、在下标 i 处插入一个字符
                int insert = dp[i + 1][j] + 1;
                // 2、替换一个字符
                int replace = dp[i][j] + 1;
                // 3、删除一个字符
                int delete = dp[i][j + 1] + 1;
                dp[i + 1][j + 1] = Math.min(Math.min(insert, replace), delete);
            }
        }
        return dp[len1][len2];
    }

}
