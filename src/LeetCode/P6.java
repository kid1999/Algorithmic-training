package LeetCode;

/**
 * @author kid1999
 * @title: P6
 * @date 2019/12/20 10:46
 */

public class P6 {
	public static void main(String[] args) {
		System.out.println(convert("LEETCODEISHIRING",3));
	}
	public static String convert(String s, int numRows) {
		if(s.equals("") || numRows == 1) return s;
		StringBuilder[] strings = new StringBuilder[numRows];
		for (int i = 0; i <numRows ; i++) {
			strings[i] = new StringBuilder();
		}
		strings[0].append(s.charAt(0));
		int index = 1;
		boolean f = false;
		while (index<s.length()){
			if(!f){
				for (int i = 1; i <numRows ; i++) {
					if(index>=s.length())break;
					strings[i].append(s.charAt(index++));
				}
				f = true;
			}else{
				for (int i =numRows-2; i >=0 ; i--) {
					if(index>=s.length())break;
					strings[i].append(s.charAt(index++));
				}
				f = false;
			}
		}
		String res = "";
		for (int i = 0; i <numRows ; i++) {
			res += strings[i];
		}
		return res;
	}
}
