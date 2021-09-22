/**
@auther: kid1999
@date: 2021/8/4 10:09
@desc: P139
**/

package main

func wordBreak(s string, wordDict []string) bool {
	dp := make([]bool, len(s) +1)
	dp[0] = true
	for i :=0 ;i<len(s) ;i++ {
		for _,word := range wordDict{
			if i-len(word) >=0{
				dp[i] = dp[i] || (dp[i-len(word)] && checkWords(s,word,i-len(word)))
			}
		}
	}
	return dp[len(s)-1]
}

func checkWords(s1 string, s2 string, i int) bool {
	for j :=0; j <len(s2);j++{
		if s1[i+j] != s2[j]{
			return false
		}
	}
	return true
}
