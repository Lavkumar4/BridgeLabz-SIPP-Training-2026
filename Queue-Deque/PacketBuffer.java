import java.util.*;

public class PacketBuffer {

    private final int[] data;
    private int front;
    private int count;
    private final int capacity;

    public PacketBuffer(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        this.capacity = capacity;
        this.data = new int[capacity];
        this.front = 0;
        this.count = 0;
    }

    /**
     * A packet arrives. Adds it to the back of the queue.
     * @return true if enqueued successfully, false if the buffer is full (rejects new packet).
     */
    public boolean enqueue(int packetId) {
        if (count == capacity) {
            return false; // buffer full: reject the new packet (explicit policy choice)
        }
        int rear = (front + count) % capacity; // next free slot, wrapping as needed
        data[rear] = packetId;
        count++;
        return true;
    }

    /**
     * A packet is processed. Removes and returns the oldest packet (FIFO).
     * @throws IllegalStateException if the buffer is empty.
     */
    public int dequeue() {
        if (count == 0) {
            throw new IllegalStateException("Buffer empty");
        }
        int val = data[front];
        front = (front + 1) % capacity; // advance front, wrapping as needed
        count--;
        return val;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }

    public int size() {
        return count;
    }

    public int capacity() {
        return capacity;
    }

    // Simple demo
    public static void main(String[] args) {
        PacketBuffer buffer = new PacketBuffer(4);

        System.out.println(buffer.enqueue(101)); // true
        System.out.println(buffer.enqueue(102)); // true
        System.out.println(buffer.enqueue(103)); // true
        System.out.println(buffer.enqueue(104)); // true
        System.out.println(buffer.enqueue(105)); // false, buffer full

        System.out.println("Processed: " + buffer.dequeue()); // 101
        System.out.println("Processed: " + buffer.dequeue()); // 102

        // Now there's room again — this will wrap around to the front of the array
        System.out.println(buffer.enqueue(105)); // true
        System.out.println(buffer.enqueue(106)); // true
        System.out.println(buffer.enqueue(107)); // false, full again (103,104,105,106)

        System.out.println("Processed: " + buffer.dequeue()); // 103
        System.out.println("Processed: " + buffer.dequeue()); // 104
        System.out.println("Processed: " + buffer.dequeue()); // 105
        System.out.println("Processed: " + buffer.dequeue()); // 106

        try {
            buffer.dequeue(); // empty, throws
        } catch (IllegalStateException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }
    }
}