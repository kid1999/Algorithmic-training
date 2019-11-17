package lanqiao.local2020;

public class C {

	public static void main(String[] args) {
		int res = 0;
		for(int i=1;i<=2019;i++){
			if(func(String.valueOf(i))) res++;
		}
		System.out.println(res);
	}
	
	public static boolean func(String n) {
		for(char c:n.toCharArray()){
			if(c == '9') return true;
		}
		return false;
	}

}
