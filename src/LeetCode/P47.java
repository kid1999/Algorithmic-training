package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kid1999
 * @title: P47
 * @date 2020/5/25 14:25
 */

public class P47 {
	// 法一： 回溯 + set去重
	// static List<List<Integer>> res;
	// static HashSet<String> set;
	// public List<List<Integer>> permuteUnique(int[] nums) {
	//     res = new ArrayList<>();
	//     set = new HashSet<>();
	//     dfs(nums,new ArrayList<>(),new boolean[nums.length],"");
	//     return res;
	// }
	// public static void dfs(int[] nums,List<Integer> tmp,boolean[] visd,String word){
	//     if(tmp.size()== nums.length) {
	//         if(!set.contains(word)) {
	//             res.add(new ArrayList<>(tmp));
	//             set.add(word);
	//         }
	//         return;
	//     }
	//     for (int i = 0; i <nums.length ; i++) {
	//         if(visd[i]) continue;
	//         visd[i] = true;
	//         tmp.add(nums[i]);
	//         dfs(nums,tmp,visd,word+nums[i]);
	//         visd[i] = false;
	//         tmp.remove(tmp.size()-1);
	//     }
	// }



	// 法二： 回溯 + 顺序去重
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		boolean[] flag = new boolean[nums.length];
		fun(nums,new ArrayList<>(),flag);
		return res;
	}
	public void fun(int[] nums,List<Integer> list,boolean[] flag){
		if(list.size()>=nums.length){
			res.add(new ArrayList<>(list));
			return;
		}
		for(int i=0;i<nums.length;i++){
			if(!flag[i]){
				list.add(nums[i]);
				flag[i] = true;
				fun(nums,list,flag);
				flag[i] = false;
				list.remove(list.size()-1);
				while(i+1<nums.length && nums[i]==nums[i+1])
					i++;
			}
		}
	}
}
