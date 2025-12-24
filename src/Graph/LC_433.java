package Graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class LC_433 {

    //Minimum Genetic Mutation

    /*A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
    Suppose we need to investigate a mutation from a gene string startGene to a 
    gene string endGene where one mutation is defined as one single character changed in the gene string.
    For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
    There is also a gene bank bank that records all the valid gene mutations. 
    A gene must be in bank to make it a valid gene string.
    Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number 
    of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.
    Note that the starting point is assumed to be valid, so it might not be included in the bank. */

    public static void main(String[] args) {
        LC_433 obj = new LC_433();
        String startGene = "AACCGGTT";
        String endGene = "AAACGGTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println(obj.minMutation(startGene, endGene, bank));
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> geneBank = new HashSet<>(Arrays.asList(bank));
        if (!geneBank.contains(endGene)) return -1;

        char[] genes = {'A','C','G','T'};
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(startGene);

        Set<String> visited = new HashSet<>();
        visited.add(startGene);

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endGene)) return steps;

                char[] currArray = curr.toCharArray();

                // Generate all single mutations
                for (int j = 0; j < currArray.length; j++) {
                    char original = currArray[j];
                    for (char g : genes) {
                        if (g == original) continue;
                        currArray[j] = g;
                        String next = new String(currArray);

                        if (geneBank.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    currArray[j] = original; // restore
                }
            }
            steps++;
        }

        return -1;
    }
    
}
