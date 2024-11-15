import java.util.Random;

public class lab1 { 
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        Random rand = new Random();

       
        System.out.println("Matrix:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = rand.nextInt(2); // Generates 0 or 1
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        // Find the row with the most 1s
        int maxRowIndex = 0;
        int maxRowCount = 0;
        for (int i = 0; i < 4; i++) {
            int rowCount = 0;
            for (int j = 0; j < 4; j++) {
                if (matrix[i][j] == 1) {
                    rowCount++;
                }
            }
            if (rowCount > maxRowCount) {
                maxRowCount = rowCount;
                maxRowIndex = i;
            }
        }

        // Find the column with the most 1s
        int maxColIndex = 0;
        int maxColCount = 0;
        for (int j = 0; j < 4; j++) {
            int colCount = 0;
            for (int i = 0; i < 4; i++) {
                if (matrix[i][j] == 1) {
                    colCount++;
                }
            }
            if (colCount > maxColCount) {
                maxColCount = colCount;
                maxColIndex = j;
            }
        }

        
        System.out.println("The largest row index: " + maxRowIndex);
        System.out.println("The largest column index: " + maxColIndex);
    }
}

