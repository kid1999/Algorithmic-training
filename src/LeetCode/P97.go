/**
@auther: kid1999
@date: 2021/8/4 7:53
@desc: P97
**/

package main

func isInterleave(s1 string, s2 string, s3 string) bool {
	if len(s1) + len(s2) != len(s3){
		return false
	}
	if len(s1) ==0 || len(s2) ==0{
		return s1+s2==s3
	}
	vis := make([][]bool,len(s1)+1)
	for i:=0; i<len(s1)+1; i++{
		vis[i] = make([]bool,len(s2)+1)
	}
	return dfs2(s1,s2,s3,0,0,vis)
}

func dfs2(s1 string, s2 string, s3 string,l int,r int,vis [][]bool) bool {
	if l == len(s1) && r == len(s2) {
		return true
	}
	if l > len(s1) || r > len(s2) || vis[l][r]{
		return false
	}
	if l < len(s1) && s3[l+r] == s1[l] && dfs2(s1,s2,s3,l+1,r,vis){
		return true
	}
	if r < len(s2) && s3[l+r] == s2[r] && dfs2(s1,s2,s3,l,r+1,vis){
		return true
	}
	vis[l][r] = true
	return false
}

func main() {
	println(isInterleave("abababababababababababababababababababababababababababababababababababababababababababababababababbb",
	"babababababababababababababababababababababababababababababababababababababababababababababababaaaba",
	"abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababbb"))
}

// dp
//func isInterleave(s1 string, s2 string, s3 string) bool {
//	n,m,t := len(s1),len(s2),len(s3)
//	if n + m != t{
//		return false
//	}
//	dp := make([][]bool,n+1)
//	for i:=0; i<=n; i++{
//		dp[i] = make([]bool,m+1)
//	}
//	dp[0][0] = true
//	for i:=0; i<=n; i++{
//		for j:=0; j<=m; j++{
//			if i>0{
//				dp[i][j] = dp[i][j] || (dp[i-1][j] && s1[i-1] == s3[i+j-1])
//			}
//			if j>0{
//				dp[i][j] = dp[i][j] || (dp[i][j-1] && s2[j-1] == s3[i+j-1])
//			}
//		}
//	}
//	return dp[n][m]
//}
