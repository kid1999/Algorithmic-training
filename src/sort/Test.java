package sort;

import base.SegmentTree;

public class Test {
	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9,11};
		SegmentTree tree = new SegmentTree(arr);
		tree.update(0,0,arr.length-1,4,6);
		int sum = tree.query(0,0,arr.length-1,2,5);
		System.out.println(sum);
	}

}
