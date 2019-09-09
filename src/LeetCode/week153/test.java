package kid1999.io.week153;

import java.security.interfaces.RSAKey;
import java.time.Year;

public class test {

	public static void main(String[] args) {
		int[] arr = {1,-2,-2,3};
		System.out.println(maximumSum(arr));
	}
	
	 public int distanceBetweenBusStops(int[] distance, int start, int destination) {
	      int res = 0,all = 0;
	      if(start>destination) {
	    	  int tmp = start;
	    	  start = destination;
	    	  destination = tmp;
	      }
	      for (int i = start; i < destination; i++) {
			res += distance[i];
	      }
	      for (int i = 0; i < distance.length; i++) {
			all += distance[i];
		}
	      return res<all-res ? res: all-res;
	  }
	 
	 public String dayOfTheWeek(int day, int month, int year) {
	    int res = 5;		// ÖÜÎå 1971.1.1
	    //year
	    for (int i = 1971; i < year; i++) {
	    	if((i%4==0&&i%100!=0)||i%400==0) {
	    		res +=366;
	    	}else {
	    		res +=365;
	    	} 		
		}
	    //month
    	if(((year%4==0&&year%100!=0)||year%400==0) && month>2) res++;
    	for (int i = 1; i < month; i++) {
			if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) res+=31;
			else res+=30;
		}
    	// day
    	res += day;
    	System.out.println(res);
    	String[] data = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    	return data[res%7];
	 }
	 
	 public static int maximumSum(int[] arr) {
	        int sum = 0;
	        int tmp = 0;
	        int flag = 0;
	        int max = Integer.MIN_VALUE;
	        boolean f = false;
	        int nummax = Integer.MIN_VALUE;
	        for (int i = 0; i < arr.length; i++) {
				if(arr[i] < 0) {
					nummax = Math.max(nummax,arr[i]);
					sum = 0;
					if(flag < 0) {
						max = Math.max(max, tmp-flag);
						tmp = sum + arr[i];
						flag = arr[i];
					}else {           
						flag = arr[i];
						tmp += arr[i];
						max = Math.max(max, tmp);
					}
				}else {
					f = true;
					sum += arr[i];
					tmp += arr[i];
					max = Math.max(max, sum);
				}
			}
	        if(f) {
	        	max = Math.max(max, tmp - flag);
		        return max;
	        }
	        else {
	        	return nummax;
	        }      
	    }
}
