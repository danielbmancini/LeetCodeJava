public class SinglyLinkedList {
    // Node class for storing data and a reference to the next node
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the list
    private Node head;
    // Size of the list
    private int size;

    // Constructor
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    // Method to add a new node to the end of the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Method to get the size of the list
    public int getSize() {
        return size;
    }

    // Method to print the elements of the list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Method to get an element by index
    public int getElementAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node current = head;
        int currentIndex = 0;
        while (currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        return current.data;
    }

}
