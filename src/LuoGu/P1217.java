package luogu;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1217 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		boolean[] check = new boolean[b+1];//用来标记是否已经访问过了，如果访问过了就打1，没访问过打0
	    List<Integer> primeList = new ArrayList<>();

	    // 欧式筛 超空间
	    for(int i = 2;i<=b;i++) {
	        if(!check[i]) {    //打了1的就不会再看了，重复赋值浪费时间
	            primeList.add(i); //count变量记录素数个数，数组记录已知的素数的值
	        }

	        for(int j=0;j<primeList.size()&&i*primeList.get(j)<b;j++) {
	            check[i*primeList.get(j)] = true; //标记 x=i*primeList[j],x位置是我访问过的位置，打1
	            if(i%primeList.get(j)==0) {   //这一部分不好理解，比方说6，之前访问过（2,3），那么6%2==0,不用再检查6%3了，真正负责记录数据的是count变量
	                break;
	            }           
	        }          
	    }  
		for(int i=0;i<primeList.size();i++) {
			if(isHui(primeList.get(i)) && primeList.get(i) >= a) {
				System.out.println(primeList.get(i));
			}
		}
	}
	public static boolean isHui(int num) {
		String s = String.valueOf(num);
		int l = 0, r = s.length()-1;
		while(l<r) {
			if(s.charAt(l) != s.charAt(r)) return false;
			l++;
			r--;
		}
		return true;
	}
	
}
