import java.util.Scanner;

public class ObjectPrac {
    private int age ;
    private int year;
    private double price;
    // public static int sl;
    public String toSting() {
        String str = new String ("Age = "+ age+ "\n"+"Year = "+ year + "\n"+"Price = "+ price);
        return str;
    }
    public int getAge(){
        return this.age;
    }
    public int getYear(){
        return this.year;
    }
    
    public double getPrice(){
        return this.price;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setPrice(double price){
        this.price=price;
    }

    public void setYear(int year){
        this.year=year;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        ObjectPrac[] Obj = new ObjectPrac[10];

        for (int i=0;i<Obj.length;i++){
            Obj[i]=new ObjectPrac();
            Obj[i].setAge(sc.nextInt());
            Obj[i].setYear(sc.nextInt());
            Obj[i].setPrice(sc.nextDouble());




        }
    }
     


    // public static void main (String[] args){
    //     Scanner sc = new Scanner (System.in);
    //     ObjectPrac obp1 = new ObjectPrac();
    //     ObjectPrac obp2 = new ObjectPrac();
    //     obp1.age = 10;
    //     obp2.age = 20;
    //     obp1.year = 2024;
    //     obp1.price = 36.5;
    //     obp2.year = 2030;
    //     obp2.price = 99.99;
    //     System.out.println(obp2.toSting());
    //     System.out.println(obp1.toSting());
    //     ObjectPrac obp3 = new ObjectPrac();
    //     obp3.age = sc.nextInt();
    //     obp3.year = sc.nextInt();
    //     obp3.price = sc.nextDouble();
        // System.out.println(obp3.toSting());

    }
    

// after taking getters and setters also making the variables as private
// to take input for the variables of an object 
// obp4.setPrice (36.5);---------1
// obp4.setPrice(sc.nextDouble())-------2
//usually when we declare a variable like int age; means, it is non static and public 