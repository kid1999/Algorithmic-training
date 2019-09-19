package LuoGu;

import java.util.Scanner;

public class P1098 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p1 = sc.nextInt();
		int p2 = sc.nextInt();
		int p3 = sc.nextInt();
		char[] texts = sc.next().toCharArray();
		StringBuffer res = new StringBuffer();
		for (int i = 0; i <texts.length ; i++) {

			if((i == 0 || i == texts.length-1) && texts[i] == '-'){
				res.append("-");
				continue;
			}

			if(texts[i] != '-') res.append(texts[i]);
			else{
				boolean flag = false;
				StringBuffer tmp = new StringBuffer();
				// 数字 || 小写字母 第 2 4 种情况
				if((Character.isDigit(texts[i-1]) && Character.isDigit(texts[i+1])) || (Character.isLowerCase(texts[i-1]) && Character.isLowerCase(texts[i+1])) ){
					if(Character.isLowerCase(texts[i-1])) flag = true;  //　是小写字母
						if(texts[i-1] < texts[i+1]) {
						for (int j = texts[i-1]+1; j <texts[i+1] ; j++) {
							for (int k = 1; k <=p2 ; k++) {
								tmp.append((char)j);
							}
						}
					}
					if(texts[i-1] >= texts[i+1]){
						res.append("-");
						continue;
					}
				}
				else {
					res.append("-");
					continue;
				}

				// 第 1 种情况
				if(p1 == 2 && flag) tmp = new StringBuffer(tmp.toString().toUpperCase());
				if(p1 == 3) {
					for (int j = 0; j <tmp.length() ; j++) {
						res.append("*");
					}
					continue;
				}
				// 第 3....
				if(p3 == 2) tmp.reverse();
				res.append(tmp);
			}
		}
		System.out.println(res);
	}
}
