package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class LC_933 {

    //Number of Recent Calls

    /* You have a RecentCounter class which counts the number of recent requests within a certain time frame.
    Implement the RecentCounter class: 
        -- RecentCounter() Initializes the counter with zero recent requests.
        -- int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, 
    and returns the number of requests that has happened in the past 3000 milliseconds (including the new request).
    Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t]. */

    public static void main(String[] args) {
        LC_933  obj = new LC_933();
        System.out.println(obj.new RecentCounter().ping(1));     // requests = [1], range is [-2999,1], return 1
        System.out.println(obj.new RecentCounter().ping(100));   // requests = [1, 100], range is [-2900,100], return 2
        System.out.println(obj.new RecentCounter().ping(3001));  // requests = [1, 100, 3001], range is [1,3001], return 3
        System.out.println(obj.new RecentCounter().ping(3002));  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
    }

    class RecentCounter {
        private Queue<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.offer(t);
            while (queue.peek() < t - 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }
    
}
