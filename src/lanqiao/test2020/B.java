package lanqiao.test2020;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream(new File("F:\\Git\\Algorithmic-training\\data\\2020.txt")));
		char[][] ss = new char[301][301];
		int n = 0;
		while(sc.hasNext()){
			String s = sc.nextLine();
			ss[n] = s.toCharArray();
			n++;
		}
		int res = 0;
		for (int i = 0; i < 300; i++) {
			for (int j = 0; j < 300; j++) {
				if(ss[i][j] == '2') res += dfs(ss,i,j);
			}
		}
		System.out.println(res);
	}
	static int dfs(char[][] ss,int i,int j){
		String s1 = "";
		String s2 = "";
		String s3 = "";
		for (int k = 0; k < 4; k++) {
			if(i+k >= 300) break;
			s1 += ss[i+k][j];
		}
		for (int k = 0; k < 4; k++) {
			if(j+k>=300) break;
			s2 += ss[i][j+k];
		}
		for (int k = 0; k < 4; k++) {
			if(i+k >= 300 || j+k>=300) break;
			s3 += ss[i+k][j+k];
		}
		int n = 0;
		if(s1.equals("2020")) n++;
		if(s2.equals("2020")) n++;
		if(s3.equals("2020")) n++;
		return n;
	}
}
