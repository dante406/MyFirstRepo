import java.util.Scanner;

public class twoda {
    public static void main (String [] args){
        Scanner sc = new Scanner (System.in);
        int r = 3 , c = 3;
        int[][] arry = new int[r][c];
        for(int i= 0; i<r; i++){
            for(int j= 0; j<c; j++){
                arry[i][j] = sc.nextInt();
            }
        }
        for(int i= 0; i<r; i++){
            for(int j= 0; j<c; j++){
                System.out.print(arry[i][j]+ " " );
            }
            System.out.println();
        }
    }
}
