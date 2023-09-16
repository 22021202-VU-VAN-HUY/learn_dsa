package week1;
import java.util.Scanner;

public class HiThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        String c = sc.next();
        System.out.println("Hi " + c + " , " + b + ", and " + a +"." );
    }
}

//input Alice Bob Carol
//output Hi Carol , Bob, and Alice.