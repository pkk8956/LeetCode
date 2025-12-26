package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_1268 {

    // Search Suggestions System

    /*You are given an array of strings products and a string searchWord.
    Design a system that suggests at most three product names from products after each character of 
    searchWord is typed. Suggested products should have common prefix with searchWord. 
    If there are more than three products with a common prefix return the three lexicographically minimums products.
    Return a list of lists of the suggested products after each character of searchWord is typed. */

    public static void main(String[] args) {
        LC_1268 obj = new LC_1268();
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        System.out.println(obj.suggestedProducts(products, searchWord));

    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        String prefix = "";

        for (char c : searchWord.toCharArray()) {
            prefix += c;
            List<String> suggestions = new ArrayList<>();
            int count = 0;

            for (String product : products) {
                if (product.startsWith(prefix)) {
                    suggestions.add(product);
                    count++;
                }
                if (count == 3) break;
            }
            result.add(suggestions);
        }
        return result;
    }
}
