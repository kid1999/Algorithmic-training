package LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kid1999
 * @title: P5
 * @date 2019/12/20 11:39
 */

public class P5 {
	public static void main(String[] args) {
		longestPalindrome("babad");
	}



	/***
	 *                    _ooOoo_
	 *                   o8888888o
	 *                   88" . "88
	 *                   (| -_- |)
	 *                    O\ = /O
	 *                ____/`---'\____
	 *              .   ' \\| |// `.
	 *               / \\||| : |||// \
	 *             / _||||| -:- |||||- \
	 *               | | \\\ - /// | |
	 *             | \_| ''\---/'' | |
	 *              \ .-\__ `-` ___/-. /
	 *           ___`. .' /--.--\ `. . __
	 *        ."" '< `.___\_<|>_/___.' >'"".
	 *       | | : `- \`.;`\ _ /`;.`/ - ` : | |
	 *         \ \ `-. \_ __\ /__ _/ .-` / /
	 * ======`-.____`-.___\_____/___.-`____.-'======
	 *                    `=---='
	 *
	 * .............................................
	 *          佛祖保佑             永无BUG
	 */


	// 1. 双端队列
//	public static String longestPalindrome(String s) {
//
//		if(s.equals("")) return s;
//		char[] chars = s.toCharArray();
//		int res = 0;
//		Deque<Character> dequRes = new LinkedList<>();
//		for (int i = 0; i <chars.length ; i++) {
//			Deque<Character> deque = new LinkedList<>();
//			Deque<Character> list = new LinkedList<>();
//			deque.add(chars[i]);
//			int len = 1;
//			while (i-len>=0 && i+len <chars.length && chars[i-len] == chars[i+len]){
//				deque.addFirst(chars[i-len]);
//				deque.addLast(chars[i+len]);
//				len++;
//			}
//			len = 0;
//			while (i-len>=0 && i+len+1 <chars.length && chars[i-len] == chars[i+len+1]){
//				list.addFirst(chars[i-len]);
//				list.addLast(chars[i+len+1]);
//				len++;
//			}
//			if(deque.size()>res){
//				res = deque.size();
//				dequRes = deque;
//			}
//			if(list.size()>res){
//				res = list.size();
//				dequRes = list;
//			}
//		}
//
//		StringBuilder stringBuilder = new StringBuilder();
//		while (!dequRes.isEmpty()){
//			stringBuilder.append(dequRes.pollFirst());
//		}
//		return stringBuilder.toString();
//	}


	// 2. 暴力搜索
//	public static String longestPalindrome(String s) {
//		int max = -1;
//		String res = "";
//		char[] chs = s.toCharArray();
//		for (int i = 0; i < chs.length; i++) {
//			for (int j = chs.length-1; j >=i ; j--) {
//				int l = i,r = j;
//				boolean f = true;
//				while (l<=r){
//					if(chs[l]!=chs[r]){
//						f = false;
//						break;
//					}
//					l++;
//					r--;
//				}
//				if(f){
//					if(max<j-i){
//						max =  j-i;
//						res = s.substring(i,j+1);
//					}
//					break;
//				}
//			}
//		}
//		return res;
//	}


	// 3. 递归
	public static String longestPalindrome(String s) {
		if(s==null || s.length() == 0) return "";
		int start = 0,end = 0;
		for (int i = 0; i <s.length() ; i++) {
			int len1 = func(s,i,i);
			int len2 = func(s,i,i+1);
			int len = Math.max(len1,len2);
			if(len>end-start){
				start = i - (len-1)/2;
				end = i+len/2;
			}
		}
		return s.substring(start,end+1);
	}

	static int func(String s,int l, int r){
		int left = l, right = r;
		while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
			left--;
			right++;
		}
		return right-left-1;
	}
}
