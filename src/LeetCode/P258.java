package LeetCode;

/**
 * @author kid1999
 * @title: P258
 * @date 2020/7/5 10:26
 */

public class P258 {
	public int addDigits(int num) {
		while (num >= 10){
			int next = 0;
			while (num != 0){
				next += num%10;
				num /= 10;
			}
			num = next;
		}
		return num;
	}
}
