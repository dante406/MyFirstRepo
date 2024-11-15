import java.util.Scanner;

public class lab4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("Enter the number of words: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 
        
        // Array to store the words
        String[] words = new String[n];
        
        // Input words from the user
        System.out.println("Enter " + n + " words:");
        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine();
        }
        
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (words[i].compareTo(words[j]) > 0) {
                   
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
        
       
        System.out.println("In lexicographical order:");
        for (String word : words) {
            System.out.println(word);
        }
        
        scanner.close();
    }
}
