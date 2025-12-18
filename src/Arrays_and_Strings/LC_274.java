package Arrays_and_Strings;

public class LC_274 {

    // H-Index

    /* Given an array of integers citations where citations[i] is the number of citations a researcher received for 
    their ith paper, return compute the researcher's h-index.
    According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have 
    at least h citations each, and the other n − h papers have no more than h citations each.*/

    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        LC_274 obj = new LC_274();
        System.out.println(obj.hIndex(citations));
    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];

        // Fill the buckets
        for (int citation : citations) {
            if (citation >= n) {
                buckets[n]++;
            } else {
                buckets[citation]++;
            }
        }

        // Calculate h-index
        int total = 0;
        for (int i = n; i >= 0; i--) {
            total += buckets[i];
            if (total >= i) {
                return i;
            }
        }
        return 0;
    }
    
}
