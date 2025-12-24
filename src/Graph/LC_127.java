package Graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LC_127 {

    // Word Ladder

    /*A transformation sequence from word beginWord to word endWord using a dictionary 
    wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
        -- Every adjacent pair of words differs by a single letter.
        -- Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
        -- sk == endWord
    Given two words, beginWord and endWord, and a dictionary wordList, return the number of words 
    in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists. */

    public static void main(String[] args) {
        LC_127 obj = new LC_127();
        String beginWord = "";
        String endWord = "";
        String[] words = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(words);
        System.out.println(obj.ladderLength(beginWord, endWord, wordList));
    }

     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        int level = 1; // startWord counts as first word

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return level;

                char[] wordChars = word.toCharArray();
                for (int j = 0; j < wordChars.length; j++) {
                    char original = wordChars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        wordChars[j] = c;
                        String nextWord = new String(wordChars);
                        if (wordSet.contains(nextWord)) {
                            queue.offer(nextWord);
                            wordSet.remove(nextWord); // mark visited
                        }
                    }
                    wordChars[j] = original;
                }
            }
            level++;
        }
        return 0;
    }
}
