

import java.util.*;

class Node 
{
    int data;
    Node p;
    Node n;

    Node(int data) 
    {
        this.data = data;
        this.p = null;
        this.n = null;
    }
}

class DoublyLinkedList 
{
    Node head;

   
    void insertAtBeginning(int data) 
    {
        Node newNode = new Node(data);
        if (head == null) 
        {
            head = newNode;
            return;
        }
        newNode.n = head;
        head.p = newNode;
        head = newNode;
    }

   
    void insertAtEnd(int data) 
    {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.n != null) 
        {
            temp = temp.n;
        }
        temp.n = newNode;
        newNode.p = temp;
    }

   
    void insertAtPosition(int data, int position) 
    {
        Node newNode = new Node(data);

        
        if (position == 1) 
        {
            insertAtBeginning(data);
            return;
        }

        Node temp = head;
        int i = 1;

        
        while (temp != null && i < position - 1) 
        {
            temp = temp.n;
            i++;
        }

        
        if (temp == null) 
        {
            System.out.println("Position out of range!");
            return;
        }

        
        if (temp.n == null) 
        {
            temp.n = newNode;
            newNode.p = temp;
            return;
        }

        
        newNode.n = temp.n;
        newNode.p = temp;
        temp.n.p = newNode;
        temp.n = newNode;
    }

   
    void display() 
    {
        if (head == null) 
        {
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        System.out.print("Doubly Linked List: ");
        while (temp != null) 
        {
            System.out.print(temp.data + " ");
            temp = temp.n;
        }
        System.out.println();
    }
}

public class main
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();

        while (true) 
        {
            System.out.println("\n=== Wherre to insert ===");
            System.out.println("1. At Beginning");
            System.out.println("2. At End");
            System.out.println("3. At Any Position");
            System.out.println("4. Display List");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int c = sc.nextInt();

            switch (c) 
            {
                case 1:
                    System.out.print("Enter data to insert at beginning: ");
                    int data1 = sc.nextInt();
                    list.insertAtBeginning(data1);
                    break;

                case 2:
                    System.out.print("Enter data to insert at end: ");
                    int data2 = sc.nextInt();
                    list.insertAtEnd(data2);
                    break;

                case 3:
                    System.out.print("Enter data to insert: ");
                    int data3 = sc.nextInt();
                    System.out.print("Enter position to insert: ");
                    int pos = sc.nextInt();
                    list.insertAtPosition(data3, pos);
                    break;

                case 4:
                    list.display();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    //sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}