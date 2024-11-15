import java.util.Scanner;

public class lab5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Define the 2D array (4x4 example)
        int[][] array = {
            {39, 27, 11, 42},
            {10, 93, 91, 90},
            {54, 78, 56, 89},
            {24, 64, 20, 65}
        };
        
        // Prompt the user to enter the column index to sort by (1-based index)
        System.out.print("Enter the column number to sort by (1-4): ");
        int column = scanner.nextInt() - 1; // Convert to 0-based index
        
        // Sort the array based on the specified column
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i][column] > array[j][column]) {
                    // Swap the entire row if element in specified column is greater
                    int[] temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        
        // Display the sorted array
        for (int[] row : array) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}
