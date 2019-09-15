package LeetCode.week154;

public class One {
	public static void main(String[] args) {
		System.out.println(maxNumberOfBalloons("dasdaad"));
	}
	public static int maxNumberOfBalloons(String text) {
		int words[] = new int[128];
		for (char c:text.toCharArray()) {
			words[c]++;
		}
		int b = words['b'];
		int a = words['a'];
		int l = words['l']/2;
		int o = words['o']/2;
		int n = words['n'];
		int min1 = Math.min(b,a);
		int min2 = Math.min(l,o);
		int min3 = Math.min(n,min1);
		int min4 = Math.min(min2, min3);
		return min4;
	}

}
