/**
@author: kid1999
@date: 2021/9/21 11:21
@desc: P1763
**/

package main

func main() {
	println(int('a'))
	println(int('A'))
	s := "1234"
	println(s[0:1])

	longestNiceSubstring("Bb")
}

func longestNiceSubstring(s string) string {
	max := 0
	res := ""
	for i := 0; i < len(s); i++ {
		for j := i; j < len(s);j++ {
			sub := s[i:j+1]
			if j-i > max && checkWord(sub){
				res = sub
				max = j-i
			}
		}
	}
	return res
}

func checkWord(s string) bool {
	ws := [128]int{}
	for _, word := range s{
		ws[word]++
	}
	for i := 65; i < 97 ; i++ {
		if ws[i] != 0 && ws[i+32] == 0{
			return false
		}
	}
	for i := 97; i < 128 ; i++ {
		if ws[i] != 0 && ws[i-32] == 0{
			return false
		}
	}
	return true
}
