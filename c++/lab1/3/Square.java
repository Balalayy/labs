import java.util.Scanner;
public class Square {
    public static void main(String[] args) {

        System.out.println("ax^2 + bx + c = 0");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите a: ");
        int a = scanner.nextInt();

        System.out.print("Введите b: ");
        int b = scanner.nextInt();
        
        System.out.print("Введите c: ");
        int c = scanner.nextInt();

        int d = b*b-4*a*c;

        if (d>0) {
            int x1 = (-b + (int)Math.sqrt(d)) / (2*a);
            int x2 = (-b - (int)Math.sqrt(d)) / (2*a);
           System.out.println("Корни: ");
            System.out.println(x1);
            System.out.print(x2);
        
        } 
        else {System.out.println("Корней нет");}
    }

}
