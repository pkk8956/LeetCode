package Heap;

import java.util.PriorityQueue;

//Find Median from Data Stream

    /*The median is the middle value in an ordered integer list. If the size of the list is even, there is no 
    middle value, and the median is the mean of the two middle values.
        - For example, for arr = [2,3,4], the median is 3.
        - For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
    Implement the MedianFinder class:
        - MedianFinder() initializes the MedianFinder object.
        - void addNum(int num) adds the integer num from the data stream to the data structure.
        - double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.*/

public class LC_295 {

    public static void main(String[] args) {
        LC_295 obj = new LC_295();
        MedianFinder mf = obj.new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }

    public class MedianFinder {

        private PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> b - a);
        private PriorityQueue<Integer> min = new PriorityQueue<>();

        public void addNum(int num) {
            if (max.isEmpty() || num <= max.peek()) max.offer(num);
            else min.offer(num);

            if (max.size() > min.size() + 1) min.offer(max.poll());
            else if (min.size() > max.size()) max.offer(min.poll());
        }

        public double findMedian() {
            if (max.size() == min.size())
                return ((long)max.peek() + min.peek()) / 2.0;

            return max.peek();
        }
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
