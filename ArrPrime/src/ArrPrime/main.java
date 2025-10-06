package ArrPrime;

import java.util.*;

public class main {

    public static void main(String[] args) {
        System.out.println("The prime numbers up to n:");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];  
        int index = 0;

        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {   
                arr[index] = i;
                index++;
            }
        }

        
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
