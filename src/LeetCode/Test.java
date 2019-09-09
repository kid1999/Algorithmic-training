package LeetCode;

import java.util.Scanner;

public class Test{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();  //学生组个数
		//用学生组个数来控制输入的每组学生数
		int[] m=new int[n];
		for(int i=0;i<n;i++){
			m[i]=sc.nextInt();
		}
		int L=sc.nextInt();
		int R=sc.nextInt();
		int l_count = 0;
		int r_count = 0;
		int l_max = 0;
		int r_max = 0;
		for(int i=0;i<m.length;i++){
			if(m[i]<=L){
				l_count+=L-m[i];		// 右移
				l_max += R-m[i];		// 右移最大值
			}
			if(m[i]>=R) {
				r_count+=m[i]-R;		// 左移
				r_max += m[i]-L;		// 左移最大值
			}
		}
		if(l_count > r_max || r_count > l_max){
			System.out.println("-1");
		}else{
			if(l_count>=r_count){
				System.out.println(l_count);
			}else{
				System.out.println(r_count);
			}
		}
	}
}
