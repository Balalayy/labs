import java.util.Scanner;
public class Palindrom {

    public static boolean IAmPalindrom(String str) {
        String clean = str.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {return false;}
            left++;
            right--;
        }
        return true;
    }

     public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String input = scanner.nextLine();

        if (IAmPalindrom(input)) {System.out.println("Палиндром");}
        else {{System.out.println("Не палиндром");}

        scanner.close();

        }
    }
}
