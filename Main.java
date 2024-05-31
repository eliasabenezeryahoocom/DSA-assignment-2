package DSA_Assignment_2;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Inserting a Node at Any Given Position
    public void insertAtPos(int data, int position) {
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // Deleting a Node at Any Given Position
    public void deleteAtPosition(int position) {
        if (position == 1) {
            head = head.next;
        } else {
            Node temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }

    // Deleting a Node After a Given Node
    public void deleteAfterNode(Node node) {
        if (node != null && node.next != null) {
            node.next = node.next.next;
        }
    }

    // Searching a Node in a Singly Linked List
    public boolean searchNode(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

class Stack {
    private LinkedList list;

    Stack() {
        list = new LinkedList();
    }

    public void push(int data) {
        list.insertAtPos(data, 1);
    }

    public int pop() {
        if (list.head == null) {
            throw new IllegalStateException("Stack is empty");
        }
        int data = list.head.data;
        list.head = list.head.next;
        return data;
    }

    public int peek() {
        if (list.head == null) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.head.data;
    }
}
public class Main {
    public static void main(String[] args) {
        // Creating a linked list
        LinkedList list = new LinkedList();

        // Inserting nodes at different positions
        list.insertAtPos(10, 1);
        list.insertAtPos(20, 2);
        list.insertAtPos(30, 3);
        list.insertAtPos(40, 4);

        // Displaying the linked list
        Node current = list.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();

        // Deleting a node at a given position
        list.deleteAtPosition(3);

        // Displaying the linked list after deletion
        current = list.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
        // Searching for a node in the linked list
        System.out.println("Is 20 present in the linked list? " + list.searchNode(20));

        // Implementing a stack using linked list
        Stack stack = new Stack();
        stack.push(50);
        stack.push(60);
        stack.push(70);

        // Popping elements from the stack
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        // Peeking at the top element of the stack
        System.out.println("Top element: " + stack.peek());
    }
}
