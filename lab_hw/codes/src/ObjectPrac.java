import java.util.Scanner;

public class ObjectPrac {
    int age ;
    int year;
    double price;
    // public static int sl;
    public String toSting() {
        String str = new String ("Age = "+ age+ "\n"+"Year = "+ year + "\n"+"Price = "+ price);
        return str;
    }

    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        ObjectPrac obp1 = new ObjectPrac();
        ObjectPrac obp2 = new ObjectPrac();
        obp1.age = 10;
        obp2.age = 20;
        obp1.year = 2024;
        obp1.price = 36.5;
        obp2.year = 2030;
        obp2.price = 99.99;
        System.out.println(obp2.toSting());
        System.out.println(obp1.toSting());
        ObjectPrac obp3 = new ObjectPrac();
        obp3.age = sc.nextInt();
        obp3.year = sc.nextInt();
        obp3.price = sc.nextDouble();
        System.out.println(obp3.toSting());

    }
    
}
// after taking getters and setters also making the variables as private
// to take input for the variables of an object 
// obp4.setPrice (36.5);---------1
// obp4.setPrice(sc.nextDouble())-------2
//usually when we declare a variable like int age; means, it is non static and public 