/**
@author: kid1999
@date: 2021/9/14 8:33
@desc: P399
**/

package main

func main() {



}


func calcEquation(equations [][]string, values []float64, queries [][]string) []float64 {
	equationsSize := len(equations)
	unionFind := UnionFind{}
	unionFind.init(2*equationsSize)
	hashMap := make(map[string]int)
	id := 0
	for i := 0; i <equationsSize; i++ {
		equation := equations[i]
		v1 := equation[0]
		v2 := equation[1]

		if _,ok := hashMap[v1]; !ok{
			hashMap[v1] = id
			id++
		}

		if _,ok := hashMap[v2]; !ok{
			hashMap[v2] = id
			id++
		}

		unionFind.union(hashMap[v1],hashMap[v2],values[i])
	}

	queriesSize := len(queries)
	res := []float64{}
	for i := 0; i < queriesSize; i++ {
		v1 := queries[i][0]
		v2 := queries[i][1]

		id1,ok1 := hashMap[v1]
		id2,ok2 := hashMap[v2]

		if !ok1 || !ok2{
			res = append(res,-1.0)
		}else{
			res = append(res,unionFind.isConnected(id1,id2))
		}

	}
	return res
}


type UnionFind struct {
	parents []int
	weight []float64
}

func (u *UnionFind) init(n int) {
	u.parents = make([]int,n)
	u.weight = make([]float64,n)
	for i := 0; i < n; i++{
		u.parents[i] = i
		u.weight[i] = 1.0
	}
}


// 路径压缩
func (u *UnionFind) FindRoot(x int) int{
	if u.parents[x] != x {
		origin := u.parents[x]
		u.parents[x] = u.FindRoot(u.parents[x])
		u.weight[x] *= u.weight[origin]
	}
	return u.parents[x]
}

func (u *UnionFind) isConnected(x,y int) float64{
	rootX := u.FindRoot(x)
	rootY := u.FindRoot(y)
	if rootY == rootX{
		return u.weight[x] / u.weight[y]
	}else{
		return  -1.0
	}
}

// 合并两个集合
func (u *UnionFind) union(x int, y int,value float64) {
	rootX := u.FindRoot(x)
	rootY := u.FindRoot(y)
	if rootX != rootY {
		u.parents[rootX] = rootY
		u.weight[rootX] = u.weight[y] * value / u.weight[x]
	}
}