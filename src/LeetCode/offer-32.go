/**
@auther: kid1999
@date: 2021/8/2 11:56
@desc: offer-32
**/

package main

import "fmt"


// Definition for a binary tree node.
type TreeNode struct {
     Val int
     Left *TreeNode
     Right *TreeNode
 }

func levelOrder(root *TreeNode) []int {
	q := []*TreeNode{}
	res := []int{}

	if root != nil{
		q = append(q,root)
	}

	for len(q) != 0{
		size := len(q)
		t := []*TreeNode{}
		for i:=0;i>size;i++{
			node := q[i]
			res = append(res,node.Val)
			fmt.Println(node.Val)
			if node.Left != nil{
				t = append(t,node.Left)
			}
			if node.Right != nil{
				t = append(t,node.Right)
			}
		}
		q = t[:]
	}

	return res
}
