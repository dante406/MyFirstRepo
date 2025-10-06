package HelloWrld;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

public static void main (String[]args) {
	
	
	/*Scanner sc=new Scanner(System.in);
	int a,b;
	a=5;
	b=4;
	int multiply;
	multiply=a*b;
	System.out.println(multiply);
	System.out.println("Enter your name");
	
	String name=sc.nextLine();5
	System.out.println(name);
	int mult=10;
	int mult1;
	for(int i=1;i<=10;i++) {
		mult1=mult*i;
		System.out.println(mult+"*"+i+"="+mult1);
	}*/
	
	
	
	
	/*System.out.println("Enter the number"); 
	Scanner sc =new Scanner(System.in);
	int n=sc.nextInt();
	int sum=0;
	System.out.println("The prime number upto n");
	for(int i=2;i<=n;i++) {
		boolean isPrime=true;
		for(int j=2;j<i;j++) {
			if((i%j)==0) {
				isPrime=false;
				break;
			}
			
		}
		if(isPrime) {
			System.out.println(i);
			sum=sum+i;
		}
	}
	
	System.out.println("sum = " +sum);*/
	
	
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the size of the array");
	
	int n=sc.nextInt();
	int arr[]=new int [n];
	
	for(int i=0;i<n;i++) {
		arr[i]=sc.nextInt();
	}
		
	for(int i=0;i<n;i++) {
		System.out.print(arr[i]);
	}

}
}
	
