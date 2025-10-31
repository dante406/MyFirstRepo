package SinglyLinkedList;
import java.util.*;

class Node {
	
    int data;
    Node next;

    // Constructor to create a new node
    Node(int value) {
        data = value;
        next = null;
    }
}

public class SinglyLinkedList {
    Node start = null; // head of the list

    // Method to create a new node (similar to getNode() in pseudo code)
    Node getNode(int value) {
        Node newNode = new Node(value);
        return newNode;
    }

    // Insert node at the beginning
    void insertAtBeginning(int value) {
        Node newNode = getNode(value);

        if (start == null) {
            start = newNode;
        } else {
            newNode.next = start;
            start = newNode;
        }
    }

    // Display all nodes
    void display() {
        Node current = start;
        while (current != null) {
            System.out.print(current.data + " → ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements to insert: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value: ");
            int value = sc.nextInt();
            list.insertAtBeginning(value);
        }

        System.out.println("\nLinked List after insertion at beginning:");
        list.display();
    }
}
