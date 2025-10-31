package DeleteEnd;

import java.util.Scanner;




class Node 
{
    int data;
    Node next;
}

class ls 
{
    Node h;

    
    Node cn(int data) 
    {
        Node n = new Node();
        n.data = data;
        n.next = null;
        return n;
    }
    int nodeCounter() 
    {
        int count = 0;
        Node temp = h;
        while (temp != null) 
        {
            count++;
            temp = temp.next;
        }
        return count;
    }
    
    void i(int data) 
    {
        Node nn = cn(data);
       if (h == null) {
            h = nn;
        } else 
        {
            Node temp = h;
            while (temp.next != null) 
            {
                temp = temp.next;
            }
            temp.next = nn;
        }
        System.out.println("Node inserted");
        if (h == null) 
        {
            h = nn;
            System.out.println("Inserted value as the first node.");
        } else 
        {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter the position to insert the node: ");
            int p = in.nextInt();
            int nodeCounter = nodeCounter();

            
            if (p > 1 && p <= nodeCounter) 
            {
                int c = 1;
                Node temp = h;

                
                while (c < p - 1) 
                {
                    temp = temp.next;
                    c++;
                }
                nn.next = temp.next;
                temp.next = nn;
                System.out.println("Node inserted at position " + p);
            } 
            
            else if (p == 1) 
            {
                nn.next = h;
                h = nn;
                System.out.println("Node inserted at beginning.");
            }
            else 
            {
                System.out.println("Invalid position!");
            }
    }
    }


   
    void d() 
    {
        if (h == null) 
        {
            System.out.println("List is empty. Nothing to delete!");
            return;
        }
        
        if (h.next == null) 
        {
            h = null;
            System.out.println("Last node deleted.");
            return;
        }
        
        Node temp = h;
        while (temp.next.next != null) 
        {
            temp = temp.next;
        }
        temp.next = null;
        System.out.println("Last node deleted.");
    }

   
    void display() 
    {
        if (h == null) 
        {
            System.out.println("List is empty!");
            return;
        }
        Node temp = h;
        System.out.print("Linked List: ");
        while (temp != null) 
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}


                //The main class::
public class main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        ls list = new ls();
        int choice, data;

        while (true) 
        {
            System.out.println("\n1. Insert Node at Any instead of end");
            System.out.println("2. Delete Node from End");
            System.out.println("3. Display List");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.i(data);
                    break;
                case 2:
                    list.d();
                    break;
                case 3:
                    list.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
