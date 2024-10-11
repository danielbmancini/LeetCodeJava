import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LeetCode189 {
    public static void main(String[] args) {
        LeetCode189 leetCode189 = new LeetCode189();

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};

        leetCode189.rotate(array, 3);
    }

    public void rotate(int[] nums, int k) {
        int useful = nums.length - k % nums.length;

        SimpleQueue<Integer> queue = new SimpleQueue<>();

        for (int num : nums)
            queue.offer(num);

        for (int i = 0; i < useful; i++) {
            queue.offer(queue.poll());
            System.out.println(queue.peek());
        }
        int index = 0;

        for (Integer num : queue)
            nums[index++] = num;


        System.out.println(Arrays.toString(nums));
    }
}

class SimpleQueue<E> extends AbstractQueue<E> {
    private LinkedList<E> list = new LinkedList<>();

    @Override
    public boolean offer(E e) {
        // Adds the element to the end of the queue
        return list.add(e);
    }

    @Override
    public E poll() {
        // Removes and returns the element from the front of the queue
        return list.isEmpty() ? null : list.removeFirst();
    }

    @Override
    public E peek() {
        // Returns the element from the front without removing it
        return list.isEmpty() ? null : list.getFirst();
    }

    @Override
    public int size() {
        // Returns the number of elements in the queue
        return list.size();
    }

    @Override
    public Iterator<E> iterator() {
        // Provides an iterator over the elements in the queue
        return list.iterator();
    }
}

