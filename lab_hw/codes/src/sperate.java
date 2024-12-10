import java.util.Scanner;

public class sperate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //String str = "East West University";
        for (int i= 0; i<str.length(); i++){
            System.out.print(str.charAt(i)+ " ");
        }
    }
    
}
