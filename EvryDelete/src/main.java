

import java.util.Scanner;

class Node 
{
    int data;
    Node prev, next;
}

class DoublyLinkedList 
{
    Node head;

      void insertAtBeginning(int data) 
    {
        Node newNode = new Node();
        newNode.data = data;
        newNode.prev = null;
        newNode.next = head;
        if (head != null)
            head.prev = newNode;
        head = newNode;
        System.out.println("Node inserted at the beginning.");
    }

    
    void insertAtEnd(int data) 
    {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if (head == null) 
        {
            newNode.prev = null;
            head = newNode;
        } else 
        {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
            newNode.prev = temp;
        }
        System.out.println("Node inserted at the end.");
    }

    
    void insertAtPosition(int data, int pos) 
    {
        if (pos == 1) 
        {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node();
        newNode.data = data;

        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) 
        {
            System.out.println("Position out of range!");
            return;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null)
            temp.next.prev = newNode;

        temp.next = newNode;

        System.out.println("Node inserted at position " + pos + ".");
    }

    
    void deleteFromBeginning() 
    {
        if (head == null) 
        {
            System.out.println("List is empty.");
            return;
        }

        System.out.println("Deleted node: " + head.data);
        head = head.next;

        if (head != null)
            head.prev = null;
    }

    
    void deleteFromEnd() 
    {
        if (head == null) 
        {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == null) 
        {
            System.out.println("Deleted node: " + head.data);
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        System.out.println("Deleted node: " + temp.data);
        temp.prev.next = null;
    }

    
    void deleteFromPosition(int pos) 
    {
        if (head == null) 
        {
            System.out.println("List is empty.");
            return;
        }

        if (pos == 1) 
        {
            deleteFromBeginning();
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos && temp != null; i++)
            temp = temp.next;

        if (temp == null) 
        {
            System.out.println("Position out of range!");
            return;
        }

        System.out.println("Deleted node: " + temp.data);

        if (temp.next != null)
            temp.next.prev = temp.prev;

        if (temp.prev != null)
            temp.prev.next = temp.next;
    }

    
    void display() 
    {
        if (head == null) 
        {
            System.out.println("List is empty.");
            return;
        }

        System.out.print("Doubly Linked List: ");
        Node temp = head;
        while (temp != null) 
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
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
        int choice, data, pos;

        while (true) 
        {
            System.out.println("\n--- DOUBLY LINKED LIST MENU ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Any Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete from Any Position");
            System.out.println("7. Display List");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.insertAtBeginning(data);
                    break;
                case 2:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 3:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    System.out.print("Enter position: ");
                    pos = sc.nextInt();
                    list.insertAtPosition(data, pos);
                    break;
                case 4:
                    list.deleteFromBeginning();
                    break;
                case 5:
                    list.deleteFromEnd();
                    break;
                case 6:
                    System.out.print("Enter position to delete: ");
                    pos = sc.nextInt();
                    list.deleteFromPosition(pos);
                    break;
                case 7:
                    list.display();
                    break;
                case 8:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}