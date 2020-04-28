package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/28 9:39
 **/
public class P664 {
    public static void main(String[] args) {
        System.out.println(strangePrinter("aabbab"));
    }
    public static int strangePrinter(String s) {
        if(s==null || s.length()==0) return 0;
        int n = s.length();
        int[][] f = new int[n+1][n+1];
        for(int len = 1; len <= n; len ++) // 枚举所有子区间
            for(int l = 0;  l + len - 1 < n; l ++)
            {
                int r = l + len - 1;  // 计算区间右端点的下标 起点 + 区间长度 - 1
                f[l][r] = f[l + 1][r] + 1;      // 正常的关系
                for(int k = l + 1; k <= r; k++ )
                {
                    if(s.charAt(k) == s.charAt(l))  // 在区间里找到和相同的字符 一起打印
                        f[l][r] = Math.min(f[l][r],f[l][k -1] + f[k + 1][r]);
                }
            }

        return f[0][n - 1];
    }
}
