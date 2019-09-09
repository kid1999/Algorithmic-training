package luogu;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1217 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		boolean[] check = new boolean[b+1];//��������Ƿ��Ѿ����ʹ��ˣ�������ʹ��˾ʹ�1��û���ʹ���0
	    List<Integer> primeList = new ArrayList<>();

	    // ŷʽɸ ���ռ�
	    for(int i = 2;i<=b;i++) {
	        if(!check[i]) {    //����1�ľͲ����ٿ��ˣ��ظ���ֵ�˷�ʱ��
	            primeList.add(i); //count������¼���������������¼��֪��������ֵ
	        }

	        for(int j=0;j<primeList.size()&&i*primeList.get(j)<b;j++) {
	            check[i*primeList.get(j)] = true; //��� x=i*primeList[j],xλ�����ҷ��ʹ���λ�ã���1
	            if(i%primeList.get(j)==0) {   //��һ���ֲ�����⣬�ȷ�˵6��֮ǰ���ʹ���2,3������ô6%2==0,�����ټ��6%3�ˣ����������¼���ݵ���count����
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
