package LeetCode;

/**
 * @author kid1999
 * @create 2020-11-11 22:03
 * @description 待记忆化
 **/
public class P514 {
    public static void main(String[] args) {
        System.out.println(findRotateSteps("caotmcaataijjxi",
                "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx"));
    }

    static int ans;
    static int[][] vis;
    public static int findRotateSteps(String ring, String key) {
        ans = Integer.MAX_VALUE;
        vis = new int[101][101];
        dfs(ring,key,0,0,0);
        return ans;
    }

    public static void dfs(String ring,String key,int i,int k,int dep){
        if(i == key.length()){
            ans = Math.min(ans,dep);
            return;
        }
        if(dep > ans) return;
//        if(vis[i][k] != 0) return;  // error
//        vis[i][k] = dep;
        for (int j = 0; j <= k ; j++) {
            if(key.charAt(i) == ring.charAt(j)){
                int n = Math.min(k-j,j+ring.length()-k);
                dfs(ring,key,i+1,j,dep + n + 1);
            }
        }
        for (int j = k+1; j < ring.length() ; j++) {
            if(key.charAt(i) == ring.charAt(j)){
                int n = Math.min(j-k,k+ring.length()-j);
                dfs(ring,key,i+1,j,dep + n + 1);
            }
        }
    }
}