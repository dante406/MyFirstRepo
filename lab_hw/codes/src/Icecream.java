import java.util.Scanner;

public class Icecream {
    private String icecreamCompany;
    private String icecreamType;
    private double icecreamPrice;

    // Default constructor
    public Icecream() {
    }

    // Getters and setters
    public String getType() {
        return this.icecreamType;
    }

    public String getCompany() {
        return this.icecreamCompany;
    }

    public double getPrice() {
        return this.icecreamPrice;
    }

    public void setType(String icecreamType) {
        this.icecreamType = icecreamType;
    }

    public void setCompany(String icecreamCompany) {
        this.icecreamCompany = icecreamCompany;
    }

    public void setPrice(double icecreamPrice) {
        this.icecreamPrice = icecreamPrice;
    }

    // Fixed typo in toString method
    public String toString() {
        String str = "Icecream Type: " + this.icecreamType + "\n";
        str += "Icecream Company: " + this.icecreamCompany + "\n";
        str += "Icecream Price: " + this.icecreamPrice + "\n";
        str += "-----------------------------------\n";
        return str;
    }

    // Check if two ice creams are equal by price
    public boolean equals(Icecream otherIcecream) {
        return this.icecreamPrice == otherIcecream.icecreamPrice;
    }

    // Compare ice creams by price
    public int compareTo(Icecream otherIcecream) {
        if (this.icecreamPrice > otherIcecream.icecreamPrice) {
            return 1;
        } else {
            return this.icecreamPrice < otherIcecream.icecreamPrice ? -1 : 0;
        }
    }

    // Main method to drive the program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of ice cream objects
        System.out.println("Enter the number of Objects to create");
        int n = sc.nextInt();
        sc.nextLine(); 

        Icecream[] iceCream = new Icecream[n];

        // Input for each ice cream object
        for (int i = 0; i < iceCream.length; ++i) {
            iceCream[i] = new Icecream();
            System.out.println("Object " + (i + 1));
            System.out.print("Enter the company Name: ");
            iceCream[i].setCompany(sc.nextLine());
            System.out.print("Enter the type: ");
            iceCream[i].setType(sc.nextLine());
            System.out.print("Enter the price: ");
            iceCream[i].setPrice(sc.nextDouble());
            sc.nextLine();
        }


        for (int i = 0; i < iceCream.length; ++i) {
            System.out.println(iceCream[i].toString());
        }

        System.out.println("Enter the company Name to search: ");
        String companyName = sc.nextLine();
        searchByCompany(iceCream, companyName);

    }

    public static void searchByCompany(Icecream[] iceCream, String str) {
        boolean found = false;
        for (Icecream ice : iceCream) {
            if (ice.getCompany().equalsIgnoreCase(str)) {
                System.out.println(ice.toString());
                found = true;
            }
        }
        if (found == false) {
            System.out.println("No ice cream found for the company: " + str);
        }
    }
}

