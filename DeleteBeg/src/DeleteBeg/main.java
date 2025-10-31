package DeleteBeg;

import java.util.Scanner;



class Node {
    int data;
    Node next;

    Node(int data) 
    {
        this.data = data;
        this.next = null;
    }
}

class LinkedList 
{
    Node start;

 
    void insert(int data) 
    {
       /*Node newNode = new Node(data);
        if (start == null) 
        {
            start = newNode;
        } else 
        {
            Node temp = start;
            while (temp.next != null) 
            {
                temp = temp.next;
            }
            temp.next = newNode;
        }*/
    	//Node newNode = getNode(data);
    	Node newNode = new Node(data);

        if (start == null) {
            start = newNode;
        } else {
            newNode.next = start;
            start = newNode;
        }
    }

    
    void deleteFromBeginning() 
    {
        if (start == null) 
        {
            System.out.println("List is empty, nothing to delete.");
        } else 
        {
            System.out.println("Deleted node: " + start.data);
            start = start.next;
        }
    }

    // Display the list
    void display() 
    {
        if (start == null) 
        {
            System.out.println("List is empty.");
            return;
        }
        Node temp = start;
        while (temp != null) 
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class main
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int c;

        do 
        {
            
            System.out.println("1. Insert node at Beg");
            System.out.println("2. Delete node from beginning");
            System.out.println("3. Display list");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            c = sc.nextInt();

            switch (c) 
            {
                case 1:
                    System.out.print("Enter data to insert: ");
                    int data = sc.nextInt();
                    list.insert(data);
                    break;
                case 2:
                    list.deleteFromBeginning();
                    break;
                case 3:
                    list.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        } while (c != 4);

    }
}