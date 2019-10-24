package lanqiao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class H {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("E:\\Git\\Algorithmic-training\\src\\lanqiao\\in.txt"));
		int k = sc.nextInt();
		List<String> words = new ArrayList<>();
		while (sc.hasNext()){
			words.add(sc.next());
		}
		int res = 0;
		int last = 0;
		boolean f = true;  //true : Bob
		for (String s:words) {
			if(s.equals("Bob") || s.equals("Bob.") || s.equals("Bob,")){
				
			}
		}

	}
}
