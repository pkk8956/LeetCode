package Data_Structure;

public class TestCases {
   public static void main(String[] args) {
        testDynamicArray();
        testLinkedList();
        testDoublyLinkedList();
        testStack();
        testQueue();
        testHashMap();
        testBST();
        testMaxHeap();
    }

    static void testDynamicArray() {
        DynamicArray<Integer> arr = new DynamicArray<>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        System.out.println("DynamicArray: " + arr);
    }

    static void testLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.print("LinkedList: ");
        for (int i = 0; i < list.size(); i++) System.out.print(list.get(i) + " ");
        System.out.println();
    }

    static void testDoublyLinkedList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.print("DoublyLinkedList: ");
        for (int i = 0; i < list.size(); i++) System.out.print(list.get(i) + " ");
        System.out.println();
    }

    static void testStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(10);
        stack.push(15);
        System.out.println("Stack pop: " + stack.pop() + ", peek: " + stack.peek());
    }

    static void testQueue() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("Queue poll: " + queue.poll() + ", peek: " + queue.peek());
    }

    static void testHashMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        System.out.println("HashMap get b: " + map.get("b"));
        map.remove("b");
        System.out.println("HashMap get b after remove: " + map.get("b"));
    }

    static void testBST() {
        BSTree<Integer> bst = new BSTree<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(4);
        bst.inorderTraversal();
        System.out.println("BSTree search 4: " + bst.search(4));
        bst.delete(3);
        bst.inorderTraversal();
    }

    static void testMaxHeap() {
        MaxHeap heap = new MaxHeap();
        heap.add(10);
        heap.add(30);
        heap.add(20);
        System.out.println("MaxHeap poll: " + heap.poll() + ", peek: " + heap.peek());
    }

    static void testDeque() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(5);
        System.out.println("Deque removeFirst: " + deque.removeFirst() + ", peekLast: " + deque.peekLast());
    }
    
}
