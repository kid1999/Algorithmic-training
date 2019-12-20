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

	public static String longestPalindrome(String s) {
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
		if(s.equals("")) return s;
		char[] chars = s.toCharArray();
		int res = 0;
		Deque<Character> dequRes = new LinkedList<>();
		for (int i = 0; i <chars.length ; i++) {
			Deque<Character> deque = new LinkedList<>();
			Deque<Character> list = new LinkedList<>();
			deque.add(chars[i]);
			int len = 1;
			while (i-len>=0 && i+len <chars.length && chars[i-len] == chars[i+len]){
				deque.addFirst(chars[i-len]);
				deque.addLast(chars[i+len]);
				len++;
			}
			len = 0;
			while (i-len>=0 && i+len+1 <chars.length && chars[i-len] == chars[i+len+1]){
				list.addFirst(chars[i-len]);
				list.addLast(chars[i+len+1]);
				len++;
			}
			if(deque.size()>res){
				res = deque.size();
				dequRes = deque;
			}
			if(list.size()>res){
				res = list.size();
				dequRes = list;
			}
		}

		StringBuilder stringBuilder = new StringBuilder();
		while (!dequRes.isEmpty()){
			stringBuilder.append(dequRes.pollFirst());
		}
		return stringBuilder.toString();
	}
}
