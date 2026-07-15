public class UndoBuffer {
    private final String[] data;
    private int top;
    private final int maxDepth;

    public UndoBuffer(int maxDepth) {
        if (maxDepth <= 0) {
            throw new IllegalArgumentException("maxDepth must be positive");
        }
        this.maxDepth = maxDepth;
        this.data = new String[maxDepth];
        this.top = -1; // -1 means empty
    }

    /**
     * Records a new edit onto the stack.
     * @return true if pushed successfully, false if the buffer is at capacity.
     */
    public boolean push(String edit) {
        if (isFull()) {
            return false; // reject; caller can decide to evict oldest, log, etc.
        }
        data[++top] = edit;
        return true;
    }

    /**
     * Undoes (removes and returns) the most recent edit.
     * @throws IllegalStateException if there is nothing to undo.
     */
    public String pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Nothing to undo");
        }
        String edit = data[top];
        data[top] = null; // avoid holding a stale reference
        top--;
        return edit;
    }

    /**
     * Returns the most recent edit without removing it.
     * @throws IllegalStateException if the buffer is empty.
     */
    public String peek() {
        if (isEmpty()) {
            throw new IllegalStateException("No edits recorded");
        }
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxDepth - 1;
    }

    public int size() {
        return top + 1;
    }

    public int capacity() {
        return maxDepth;
    }

    // Simple demo
    public static void main(String[] args) {
        UndoBuffer buffer = new UndoBuffer(3);

        System.out.println(buffer.push("Type 'Hello'"));      // true
        System.out.println(buffer.push("Type ' World'"));     // true
        System.out.println(buffer.push("Bold text"));         // true
        System.out.println(buffer.push("Italicize"));         // false, at capacity

        System.out.println("Peek: " + buffer.peek());         // Bold text
        System.out.println("Undo: " + buffer.pop());          // Bold text
        System.out.println("Undo: " + buffer.pop());          // Type ' World'

        System.out.println(buffer.push("Underline"));         // true, room again

        System.out.println("Undo: " + buffer.pop());          // Underline
        System.out.println("Undo: " + buffer.pop());          // Type 'Hello'

        try {
            buffer.pop(); // empty, throws
        } catch (IllegalStateException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }
    }
}