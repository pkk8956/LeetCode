package Heap;

import java.util.PriorityQueue;
import java.util.Set;

public class LC_2336 {

    // Smallest Number in Infinite Set

    /*You have an infinite set of positive integers: {1, 2, 3, 4, 5, ...}.
      Implement the SmallestInfiniteSet class:
        -- SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
        -- int popSmallest() Removes and returns the smallest integer contained in the infinite set.
        -- void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.*/

    public static void main(String[] args) {
        LC_2336 obj = new LC_2336();
        SmallestInfiniteSet smallestInfiniteSet = obj.new SmallestInfiniteSet();
        System.out.println(smallestInfiniteSet.popSmallest()); // return 1
        System.out.println(smallestInfiniteSet.popSmallest()); // return 2
        smallestInfiniteSet.addBack(1); // 1 is added back to the set.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 1
        System.out.println(smallestInfiniteSet.popSmallest()); // return 3
    }

    public class SmallestInfiniteSet {
        private PriorityQueue<Integer> minHeap;
        private Set<Integer> addedSet;
        private int nextSmallest;

        public SmallestInfiniteSet() {
            minHeap = new java.util.PriorityQueue<>();
            addedSet = new java.util.HashSet<>();
            nextSmallest = 1;
        }

        public int popSmallest() {
            if (!minHeap.isEmpty()) {
                int smallest = minHeap.poll();
                addedSet.remove(smallest);
                return smallest;
            } else {
                return nextSmallest++;
            }
        }

        public void addBack(int num) {
            if (num < nextSmallest && !addedSet.contains(num)) {
                minHeap.offer(num);
                addedSet.add(num);
            }
        }

    
        
    }

}
