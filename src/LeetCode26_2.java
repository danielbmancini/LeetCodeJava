import java.util.Arrays;

public class LeetCode26_2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        SinglyLinkedList list = new SinglyLinkedList();

        int lastVisited = nums[0];
        list.add(0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != lastVisited) {
                list.add(i);
                lastVisited = nums[i];
            }
        }

        for (int i = 0; i < list.getSize(); i++)
            nums[i] = nums[list.getElementAtIndex(i)];

        System.out.println(Arrays.toString(nums));
        return list.getSize();
    }

    public static void main(String[] args) {
        LeetCode26_2 leetCode26_2 = new LeetCode26_2();

        System.out.println(leetCode26_2.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
    }

}
class SinglyLinkedList {
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
