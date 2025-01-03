// public class Fraction {
//     private int numerator;
//     private int denominator;
//     Fraction(){

//     }
//     Fraction(int numerator,int denominator){
//         this.numerator=numerator;
//         this.denominator=denominator;
//     }
//     //getters
//     public int getNumerator(){
//         return this.numerator;
//     }
//     public int getDenominator(){
//         return this.denominator;
//     }
//     //setters
//     public void setNumerator(int numerator){
//         this.numerator=numerator;
//     }
//     public void setDenominator (int denominator){
//         this.denominator=denominator;
//     }
    
//     public String toString() {

//         String output;
//         output="The value of the fraction"+this.getNumerator()+"/"+this.getDenominator()+"\n";
//         return output;
//     }
//     public double multiply(Fraction x1, Fraction x2){
//         double val1=x1.fractionValue();
//         double val2=x2.fractionValue();
//         double val=val1*val2;
//         //(x1/x2)*(x3/x4)=
//         //5/10+7/11
//         return val;
//     }
//     public double devide(Fraction x1, Fraction x2){
//         double val1=x1.fractionValue();
//         double val2=x2.fractionValue();
//         double val=val1/val2;
//         //(x1/x2)*(x3/x4)=
//         //5/10+7/11
//         return val;
//     }
    
//     public double add( Fraction x1 ,Fraction x2){
//         double val1=x1.fractionValue();
//         double val2=x2.fractionValue();
//         double val=val1+val2;
//         //(x1/x2)+(x3/x4)=
//         //5/10+7/11
//         return val;
//     }
//     public double fractionValue(){
//         double numerator_f= (double)this.numerator;
//         double denominator_f=(double)this.denominator;
//         double value=numerator_f/denominator_f;
//         return value;
//     }

//     public static void main(String[] args) {
//         Fraction a1=new Fraction(5,10);
//         Fraction a2=new Fraction(7,11);
//         System.out.println(a1.toString());
//         System.out.println(a1.add(a1, a2));
//         System.out.println(a1.multiply(a1, a2));
//         System.err.println(a1.devide(a1, a2));
//     }

// }

import java.util.Scanner;

public class Fraction {
    private int numerator;
    private int denominator;

    // Default constructor
    Fraction() {
    }

    // Parameterized constructor
    Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Getters
    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    // Setters
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    // toString method
    public String toString() {
        return "The value of the fraction: " + this.getNumerator() + "/" + this.getDenominator();
    }

    // Multiplication
    public double multiply(Fraction x1, Fraction x2) {
        double val1 = x1.fractionValue();
        double val2 = x2.fractionValue();
        return val1 * val2;
    }

    // Division
    public double divide(Fraction x1, Fraction x2) {
        double val1 = x1.fractionValue();
        double val2 = x2.fractionValue();
        return val1 / val2;
    }

    // Addition
    public double add(Fraction x1, Fraction x2) {
        double val1 = x1.fractionValue();
        double val2 = x2.fractionValue();
        return val1 + val2;
    }

    // Get fraction value as a double
    public double fractionValue() {
        return (double) this.numerator / this.denominator;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for first fraction
        System.out.println("Enter the numerator for the first fraction:");
        int numerator1 = scanner.nextInt();
        System.out.println("Enter the denominator for the first fraction:");
        int denominator1 = scanner.nextInt();

        // Input for second fraction
        System.out.println("Enter the numerator for the second fraction:");
        int numerator2 = scanner.nextInt();
        System.out.println("Enter the denominator for the second fraction:");
        int denominator2 = scanner.nextInt();

        // Create Fraction objects
        Fraction a1 = new Fraction(numerator1, denominator1);
        Fraction a2 = new Fraction(numerator2, denominator2);

        // Perform operations and display results
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println("Addition: " + a1.add(a1, a2));
        System.out.println("Multiplication: " + a1.multiply(a1, a2));
        System.out.println("Division: " + a1.divide(a1, a2));

        scanner.close();
    }
}
