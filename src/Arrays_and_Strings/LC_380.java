package Arrays_and_Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_380 {

    // Insert Delete GetRandom O(1)

    /* Design a data structure that supports all following operations in average O(1) time.
    insert(val): Inserts an item val to the set if not already present.
    remove(val): Removes an item val from the set if present.
    getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.*/

    public static void main(String[] args) {
        LC_380 obj = new LC_380();
        RandomizedSet randomizedSet = obj.new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // true
        System.out.println(randomizedSet.remove(2)); // false
        System.out.println(randomizedSet.insert(2)); // true
        System.out.println(randomizedSet.getRandom()); // 1 or 2
        System.out.println(randomizedSet.remove(1)); // true
        System.out.println(randomizedSet.insert(2)); // false
        System.out.println(randomizedSet.getRandom()); // 2
    }

    class RandomizedSet {

        private List<Integer> values;
        private Map<Integer, Integer> valuesIdx;

        public RandomizedSet() {
            this.values = new ArrayList<>();
            this.valuesIdx = new HashMap<>();
        }

        // Inserts a value to the set. Returns true if the set did not already contain the specified element.
        public boolean insert(int val) {
            // If the value already exists, return false
            if (valuesIdx.containsKey(val)) return false;
            // Add the value and its index
            valuesIdx.put(val, values.size());
            // Append the value to the list
            values.add(val);
            return true;
        }

        // Removes a value from the set. Returns true if the set contained the specified element.
        public boolean remove(int val) {
            // If the value does not exist, return false
            if (!valuesIdx.containsKey(val)) return false;
            // Swap the value with the last element and remove it
            int index = valuesIdx.get(val);
            // Update the index of the last element
            valuesIdx.put(values.get(values.size() - 1), index);
            // Remove the value
            valuesIdx.remove(val);
            // Swap in the list and remove the last element
            values.set(index, values.get(values.size() - 1));
            // Remove the last element
            values.remove(values.size() - 1);
            return true;
        }

        // Get a random element from the set.
        public int getRandom() {
            // Generate a random index and return the value at that index
            int index = (int) (Math.random() * values.size());
            return values.get(index);
        }
    }
}