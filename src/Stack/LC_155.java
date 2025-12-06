package Stack;

public class LC_155 {

    //Min Stack

    /*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
        MinStack() -- initializes the stack object.
        push(x) -- Push element x onto stack.
        pop() -- Removes the element on top of the stack.
        top() -- Get the top element.
        getMin() -- Retrieve the minimum element in the stack.*/

    public static void main(String[] args) {
        LC_155 obj = new LC_155();

        MinStack minStack = obj.new MinStack();
        minStack.push(-2);  
        minStack.push(0);
        minStack.push(-3);  
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
    
    class MinStack {

        private Node head;

        private static class Node {
            int val, min;
            Node next;

            Node(int val, int min, Node next) {
                this.val = val; this.min = min; this.next = next;
            }
        }

        public void push(int val) {
            if (head == null) head = new Node(val, val, null);
            else head = new Node(val, Math.min(val, head.min), head);
        }

        public void pop() {
            if (head != null) head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }
    }

    /*
    class MinStack {

        private ArrayDeque<Integer> stack;
        private ArrayDeque<Integer> minStack;

        public MinStack() {
            stack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
        }
    
        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) minStack.push(val);
        }
    
        public void pop() {
            int removed = stack.pop();
            if (removed == minStack.peek()) minStack.pop();
        }
    
        public int top() {
            return stack.peek();
        }
    
        public int getMin() {
            return minStack.peek();
        }
        
    }
    */
}
