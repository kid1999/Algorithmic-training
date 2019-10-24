package lanqiao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class H {
	private static char[] words;
	public static void main(String[] args) throws IOException {
		BufferedReader bfreader = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Algorithmic-training\\data\\in")));
		int k = Integer.parseInt(bfreader.readLine());
		words = bfreader.readLine().toCharArray();
		int last = -10000000;
		boolean flag = false;		// bob
		int res = 0;
		for (int i = 0; i <words.length ; i++) {
			if(words[i] == 'B' && isBob(i)){
				if(i-last<=k && flag) res++;
				last = i;
				flag = false;
			}
			if(words[i] == 'A' && isAlice(i)){
				if(i-last<=k && !flag) res++;
				last = i;
				flag = true;
			}
		}
		System.out.println(res);
	}
	public static boolean isBob(int cur){
		if(cur+3 >= words.length) return false;
		if(words[cur+1] == 'o' && words[cur+2] == 'b' && !Character.isLowerCase(words[cur+3]) && !Character.isUpperCase(words[cur+3])) return true;
		else return false;
	}

	public static boolean isAlice(int cur){
		if(cur+6 >= words.length) return false;
		if(words[cur+1] == 'l' && words[cur+2] == 'i' &&
						words[cur+3] == 'c' && words[cur+4] == 'e'
						&& !Character.isLowerCase(words[cur+5]) && !Character.isUpperCase(words[cur+6])) return true;
		else return false;
	}
}
