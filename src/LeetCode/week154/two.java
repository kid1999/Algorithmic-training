package LeetCode.week154;

public class two {
	public static void main(String[] args) {
		System.out.println(reverseParentheses( "a(bcdefghijkl(mno)p)q"));
	}
	public static String reverseParentheses(String s) {
		StringBuffer res = new StringBuffer(s);
		StringBuffer pre = new StringBuffer();
		StringBuffer end = new StringBuffer();

		int l = 0,r = res.length()-1;
		while (l <= r){
			while(l <= r && res.charAt(l) != '(' && res.charAt(l) != ')'){
				pre.append(res.charAt(l));
				l++;
			}
			while(r >= l && res.charAt(r) != ')' && res.charAt(r) != '('){
				end.append(res.charAt(r));
				r--;
			}
			if(l>r) break;
			res = new StringBuffer(res.substring(l+1,r)).reverse();
			l = 0;
			r = res.length()-1;
		}
		return pre.toString() + end.reverse().toString();
	}
}
