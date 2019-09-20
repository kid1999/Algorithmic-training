import java.util.Arrays;
import java.util.Scanner;

class User implements Comparable<User>{
	int id;
	int grade;

	public User(int id, int grade) {
		this.id = id;
		this.grade = grade;
	}

	@Override
	public int compareTo(User other) {
		if(other.grade > this.grade) return 1;
		else if(other.grade < this.grade) return -1;
		else {
			return this.id - other.id;
		}
	}
}

public class P1068 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		User[] users = new User[n];
		for (int i = 0; i <n ; i++) {
			users[i] = new User(sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(users);
		int num = (int) (m*1.5);
		int last = 0,count = 0;
		for (int i = 0; i <n ; i++) {
			if(i < num) last = users[i].grade;
			else if(users[i].grade == last) count++;
			else break;
		}
		System.out.println(last + " " + (num+count));
		for (int i = 0; i <num+count ; i++) {
			System.out.println(users[i].id + " " + users[i].grade);
		}

	}
}
