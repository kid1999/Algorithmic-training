/**
@auther: kid1999
@date: 2021/8/3 9:15
@desc: P95
**/

package main

func generateTrees(n int) []*TreeNode {
	res := []*TreeNode{}
	vis := make([]bool, n+1)
	for i := 1; i <= n; i++ {
		vis[i] = true
		head := &TreeNode{i,nil,nil}
		dfs1(&res,vis,head,head,1)
		vis[i] = false
	}
	return res
}

func dfs1(res *[]*TreeNode,vis []bool,root *TreeNode,header *TreeNode,count int) {
	if count == len(vis) {
		*res = append(*res,header)
	}
	for i := 1; i < len(vis); i++{
		if !vis[i]{
			vis[i] = true
			if root.Val > i{
				root.Left = &TreeNode{i,nil,nil}
				dfs1(res,vis,root.Left,header,count+1)
			}else if root.Val < i{
				root.Right = &TreeNode{i,nil,nil}
				dfs1(res,vis,root.Right,header,count+1)
			}
			vis[i] = false
		}
	}
}