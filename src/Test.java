import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/19 16:31
 **/
public class Test {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();

        System.out.println("1  2  3  4  5  6  7");
        LocalDate firstDay = now.minusDays(day - 1);
        DayOfWeek week = firstDay.getDayOfWeek();
        for (int i = 1; i < week.getValue() ; i++) {
            System.out.print("   ");
        }
        while (firstDay.getMonthValue() == month){
            System.out.printf("%d",firstDay.getDayOfMonth());
            if(firstDay.getDayOfMonth() == day) System.out.print("*");
            else System.out.print(" ");
            if(firstDay.getDayOfWeek().getValue() == 7) System.out.println();
            firstDay = firstDay.plusDays(1);
        }
    }
}
