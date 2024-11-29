import java.util.Scanner;

public class Fraction {
    private int numerator;
    private int denominator;

    // Constructor
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Default constructor
    public Fraction() {
    }

    // Getters
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // Setters
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    // Add another fraction
    public void add(Fraction fraction) {
        numerator = numerator * fraction.denominator + fraction.numerator * denominator;
        denominator = denominator * fraction.denominator;
    }

    // Subtract another fraction
    public void sub(Fraction fraction) {
        numerator = numerator * fraction.denominator - fraction.numerator * denominator;
        denominator = denominator * fraction.denominator;
    }

    // Multiply with another fraction
    public void multiplication(Fraction fraction) {
        numerator *= fraction.numerator;
        denominator *= fraction.denominator;
    }

    // Divide by another fraction
    public void division(Fraction fraction) {
        numerator *= fraction.denominator;
        denominator *= fraction.numerator;
    }

    // toString method
    public String toString() {
        return numerator + " / " + denominator;
    }

    // Main method to test the Fraction class
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for the first fraction
        System.out.println("Enter numerator and denominator for the first fraction:");
        int num1 = sc.nextInt();
        int den1 = sc.nextInt();
        Fraction fraction1 = new Fraction(num1, den1);

        // Input for the second fraction
        System.out.println("Enter numerator and denominator for the second fraction:");
        int num2 = sc.nextInt();
        int den2 = sc.nextInt();
        Fraction fraction2 = new Fraction(num2, den2);

        // Display the fractions
        System.out.println("\nInitial Fractions:");
        System.out.println("Fraction 1: " + fraction1);
        System.out.println("Fraction 2: " + fraction2);

        // Test addition
        fraction1.add(fraction2);
        System.out.println("\nAfter Addition:");
        System.out.println("Fraction 1: " + fraction1);

        // Reset fraction1 to its original value
        fraction1 = new Fraction(num1, den1);

        // Test subtraction
        fraction1.sub(fraction2);
        System.out.println("\nAfter Subtraction:");
        System.out.println("Fraction 1: " + fraction1);

        // Reset fraction1 to its original value
        fraction1 = new Fraction(num1, den1);

        // Test multiplication
        fraction1.multiplication(fraction2);
        System.out.println("\nAfter Multiplication:");
        System.out.println("Fraction 1: " + fraction1);

        // Reset fraction1 to its original value
        fraction1 = new Fraction(num1, den1);

        // Test division
        fraction1.division(fraction2);
        System.out.println("\nAfter Division:");
        System.out.println("Fraction 1: " + fraction1);

        sc.close();
    }
}
