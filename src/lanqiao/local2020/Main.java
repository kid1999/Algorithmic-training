
//�������з�ϵͳҪ��������¹���
// 1�� ������package�ؼ���
// 2�� ��������������Main

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] nums = new int[n+1];
		PriorityQueue<Integer> q = new PriorityQueue<>(m);
		for(int i=0;i<n;i++){
			int num = sc.nextInt();
			nums[i] = num;
			if(q.size() <m) q.add(num);
			else if(q.peek() < num){
				q.poll();
				q.add(num);
			}
		}
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<m;i++){
			int qq = q.poll();
			if(map.containsKey(qq)){
				map.put(qq,map.get(qq)+1);
			}else{
				map.put(qq,1);
			}			
		}
		for(int i=0;i<n;i++){
			if(map.containsKey(nums[i])){
				System.out.print(nums[i] + " ");
				map.put(nums[i], map.get(nums[i])-1);
			}
		}
	}
}
	