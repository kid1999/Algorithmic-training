package LuoGu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1443 {
	public static void main(String[] args) {
		class node{
			public node(int x, int y) {
				this.x = x;
				this.y = y;
			}
			public int x;
			public int y;
		}
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int b = sc.nextInt();
		int a = sc.nextInt();
		Queue<node> q = new LinkedList<>();
		int[][] used = new int[n+1][m+1];
		q.offer(new node(a,b));
		int len = 1;
		int num = 1;
		used[b][a] = num++;
		while (!q.isEmpty()){
			int count = 0;
			for (int i = 0; i <len ; i++) {
				node node = q.poll();
				int x = node.x;
				int y = node.y;
				// 开始遍历马的所有路线
				if(x+1<=m){
					if(y+2<=n && used[y+2][x+1] == 0){
						used[y+2][x+1] = num;
						q.offer(new node(x+1,y+2));
						count++;
					}
					if(y-2>0 && used[y-2][x+1] == 0){
						used[y-2][x+1] = num;
						q.offer(new node(x+1,y-2));
						count++;
					}
				}
				if(x-1>0){
					if(y+2<=n && used[y+2][x-1] == 0){
						used[y+2][x-1] = num;
						q.offer(new node(x-1,y+2));
						count++;
					}
					if(y-2>0 && used[y-2][x-1] == 0){
						used[y-2][x-1] = num;
						q.offer(new node(x-1,y-2));
						count++;
					}
				}
				if(x-2>0){
					if(y+1<=n && used[y+1][x-2] == 0){
						used[y+1][x-2] = num;
						q.offer(new node(x-2,y+1));
						count++;
					}
					if(y-1>0 && used[y-1][x-2] == 0){
						used[y-1][x-2] = num;
						q.offer(new node(x-2,y-1));
						count++;
					}
				}
				if(x+2<=m){
					if(y+1<=n && used[y+1][x+2] == 0){
						used[y+1][x+2] = num;
						q.offer(new node(x+2,y+1));
						count++;
					}
					if(y-1>0 && used[y-1][x+2] == 0){
						used[y-1][x+2] = num;
						q.offer(new node(x+2,y-1));
						count++;
					}
				}
			}
			num++;
			len = count;
		}

		for (int i = 1; i <=n; i++) {
			for (int j = 1; j <=m ; j++) {
				System.out.printf("%-5d", used[i][j]-1);
			}
			System.out.println();
		}
	}
}
