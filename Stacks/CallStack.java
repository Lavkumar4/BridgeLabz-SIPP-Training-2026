public class CallStack {

    private static class Frame {
        String functionName;
        Frame next;

        Frame(String name, Frame next) {
            this.functionName = name;
            this.next = next;
        }
    }

    private Frame top = null;
    private int size = 0;

    /** A function is called — push a new frame onto the stack. */
    public void push(String functionName) {
        top = new Frame(functionName, top); // new node points to old top FIRST
        size++;
    }

    /** A function returns — pop and return the top frame's name. */
    public String pop() {
        if (isEmpty()) {
            throw new IllegalStateException("No active call to return from");
        }
        String name = top.functionName;
        top = top.next; // old top node becomes unreachable -> eligible for GC
        size--;
        return name;
    }

    /** See the currently executing function without returning from it. */
    public String peek() {
        if (isEmpty()) {
            throw new IllegalStateException("No active call");
        }
        return top.functionName;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int depth() {
        return size;
    }

    /** Optional: visualize the current call stack, top to bottom. */
    public void printStackTrace() {
        Frame cur = top;
        int level = size;
        while (cur != null) {
            System.out.println("  ".repeat(size - level) + "at " + cur.functionName);
            cur = cur.next;
            level--;
        }
    }

    // Simple demo
    public static void main(String[] args) {
        CallStack calls = new CallStack();

        calls.push("main");
        calls.push("processRequest");
        calls.push("validateInput");
        calls.push("checkFormat");

        System.out.println("Currently executing: " + calls.peek()); // checkFormat
        System.out.println("Call depth: " + calls.depth());          // 4

        calls.printStackTrace();
        // at checkFormat
        // at validateInput
        // at processRequest
        // at main

        System.out.println("Returning from: " + calls.pop());  // checkFormat
        System.out.println("Returning from: " + calls.pop());  // validateInput
        System.out.println("Currently executing: " + calls.peek()); // processRequest

        calls.pop();
        calls.pop();

        try {
            calls.pop(); // empty, throws
        } catch (IllegalStateException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }
    }
}