package LeetCode.pro2019;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class Test2 {
	public static void main(String[] args) {
		String comm = "URR";
		int[][] arr = {{4, 2}};
		int x = 3;
		int y = 2;
		System.out.println(robot(comm, arr, x, y));
	}

	public static boolean robot(String command, int[][] obstacles, int x, int y) {
		int a = 0;
		int b = 0;
		Set<Pair<Integer,Integer>> set = new HashSet<>();
		if(obstacles.length != 0)
		for (int[] node:obstacles) {
			set.add(new Pair<>(node[0],node[1]));
		}
		while (a <= x || b <= y){
			for (char c:command.toCharArray()) {
				if(c == 'U') b++;
				if(c == 'R') a++;
				if(a == x && b == y) return true;
				if(set.contains(new Pair<>(a, b))) return false;
			}
		}
		return false;
	}

}
