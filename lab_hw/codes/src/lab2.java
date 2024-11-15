import java.util.Scanner;

public class lab2 {
    public static boolean isValidPassword(String password) {
        // Rule 1: Password must have at least eight characters
        if (password.length() < 8) {
            return false;
        }

        // Rule 2: Check if the password consists only of letters and digits
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))) {
                return false;
            }
        }

        // Rule 3: Check if the password contains at least two digits
        int digitCount = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (ch >= '0' && ch <= '9') {
                digitCount++;
            }
        }
        if (digitCount < 2) {
            return false;
        }

        // If all conditions are met, the password is valid
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        if (isValidPassword(password)) {
            System.out.println("Valid Password");
        } else {
            System.out.println("Invalid Password");
        }

        scanner.close();
    }
}
    

