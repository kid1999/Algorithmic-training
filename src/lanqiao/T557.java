package lanqiao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author kid1999
 * @title: T557
 * @date 2020/5/26 9:45
 */

public class T557 {
	private static class Student{
		int id;
		int math;
		int english;
		int chinese;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Student[] students = new Student[n];
		for (int i = 0; i <n ; i++) {
			students[i] = new Student();
			students[i].id = i+1;
			students[i].math = sc.nextInt();
			students[i].english = sc.nextInt();
			students[i].chinese = sc.nextInt();
		}
		Arrays.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.math!=o2.math) return o2.math-o1.math;
				else{
					if(o1.english!=o2.english) return o2.english-o1.english;
					else return o2.chinese-o1.chinese;
				}
			}
		});
		for (int i = 0; i < n; i++) {
			System.out.println(students[i].math + " " +students[i].english + " " + students[i].chinese + " "+students[i].id);
		}
	}
}
