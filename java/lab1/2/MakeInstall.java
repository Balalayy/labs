public class MakeInstall {
     public static void main(String[] args) {
        String str = "make install";
        System.out.println(str); 

        int l = str.length();
        for (int x = l - 1; x >= 0; x--) { 
            System.out.print(str.charAt(x)); 
        }

    }
}   