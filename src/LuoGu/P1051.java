package LuoGu;

import java.util.Scanner;

public class P1051 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String res_name = "";
		int max = 0;
		int sum = 0;
		for (int i = 0; i <n ; i++) {
			int money = 0;
			String name = sc.next();
			int avg_grade = sc.nextInt();
			int class_grade = sc.nextInt();
			boolean ganbu = sc.next().equals("Y") ? true :false;
			boolean xibu = sc.next().equals("Y") ? true :false;
			int lunwen = sc.nextInt();

			if(avg_grade > 80 && lunwen >= 1) money += 8000;
			if(avg_grade > 85 && class_grade > 80) money += 4000;
			if(avg_grade > 90) money += 2000;
			if(avg_grade > 85 && xibu) money += 1000;
			if(class_grade > 80 && ganbu) money += 850;

			sum += money;
			if(money > max) {
				max = money;
				res_name = name;
			}
			if(money == max && res_name.compareTo(name) == -1){
				res_name = name;
			}
		}

		System.out.println(res_name);
		System.out.println(max);
		System.out.println(sum);
	}
}
