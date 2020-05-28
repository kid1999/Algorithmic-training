package LeetCode;

import java.util.*;

/**
 * @author kid1999
 * @title: P90
 * @date 2020/5/28 20:16
 */

public class P90 {

//	List<List<Integer>> res = new ArrayList<>();
//	Set<String> set = new HashSet<>();
//	public List<List<Integer>> subsetsWithDup(int[] nums) {
//		Arrays.sort(nums);
//		dfs(new ArrayList<>(),nums,new boolean[nums.length],"",0);
//		return res;
//	}
//
//	void dfs(List<Integer> list,int[] nums,boolean[] vis,String s,int i){
//		if(!set.contains(s)){
//			res.add(new ArrayList<>(list));
//			set.add(s);
//		}
//		for (int j = i; j <nums.length ; j++) {
//			if(!vis[j]){
//				vis[j] = true;
//				list.add(nums[j]);
//				dfs(list,nums,vis,s + nums[j],j+1);
//				list.remove(list.size()-1);
//				vis[j] = false;
//			}
//		}
//	}



	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		dfs(res,new ArrayList<>(),nums,0);
		return res;
	}

	void dfs(List<List<Integer>> res,List<Integer> tmp,int[] nums,int start){
		res.add(new ArrayList<>(tmp));
		for (int j = start; j <nums.length ; j++) {
			if(j>start && nums[j] == nums[j-1]) continue;       // 标准排序去重
			tmp.add(nums[j]);
			dfs(res,tmp,nums,j+1);
			tmp.remove(tmp.size()-1);
		}
	}
}
