import java.util.Scanner;

public class P1422 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double use = sc.nextDouble();
        double price =0;
        if(use<=150){
            price += use*0.4463;
        }else if(use<=400){
            price += (150*0.4463 + (use-150)*0.4663);
        }else{
            price += (150*0.4463 + 250*0.4663 + (use-400)*0.5663);
        }
        System.out.printf("%.1f",price);
    }
}
