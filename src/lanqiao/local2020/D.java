package lanqiao.local2020;

public class D {
	static int res = 0;
	public static void main(String[] args) {
		dfs(0,0,0);
		System.out.println(res);
	}
	public static void dfs(int i,int j,int count){
		if(i<0||i>=8||j<0||j>=8||count>14) return;
		if(i==7&&j==7&&count==14){
			res++;
			return;
		}
		dfs(i+1,j,count+1);
		dfs(i,j+1,count+1);
	}

}
