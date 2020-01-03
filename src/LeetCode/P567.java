package LeetCode;

/**
 * @author kid1999
 * @title: P567
 * @date 2020/1/3 17:00
 */

public class P567 {
	public static void main(String[] args) {
		System.out.println(checkInclusion("abc","dcba"));
	}


	public static boolean checkInclusion(String s1, String s2) {
		if(s1.length() > s2.length()) return false;
		int[] aim = new int[26];
		for (char word:s1.toCharArray()) {
			aim[word -'a']++;
		}
		int len = s1.length();
		char last = 0;
		for (int i = 0; i <len ; i++) {
			aim[s2.charAt(i) - 'a']--;
		}
		for (int i = len; i <s2.length() ; i++) {
			if(checkNum(aim)) return true;
			aim[s2.charAt(last) - 'a']++;
			aim[s2.charAt(i) - 'a']--;
			last++;
		}
		if(checkNum(aim)) return true;
		return false;
	}

	public static boolean checkNum(int[] nums){
		for (int n : nums){
			if(n != 0) return false;
		}
		return true;
	}

}
