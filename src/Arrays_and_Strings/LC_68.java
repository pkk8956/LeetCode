package Arrays_and_Strings;

import java.util.ArrayList;
import java.util.List;

public class LC_68 {

    // Text Justification

    /* Given an array of strings words and a width maxWidth, format the text such that each line has exactly 
    maxWidth characters and is fully (left and right) justified.
    You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
    Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
    Extra spaces between words should be distributed as evenly as possible.
    If the number of spaces on a line does not divide evenly between words, the empty slots on the left 
    will be assigned more spaces than the slots on the right.
    For the last line of text, it should be left-justified, and no extra space is inserted between words.*/

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        LC_68 obj = new LC_68();
        System.out.println(obj.fullJustify(words, maxWidth));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        // Resultant list of justified lines
        List<String> result = new ArrayList<>();
        int index = 0;
        // Process words until all are handled
        while (index < words.length) {
            // Determine the range of words that fit in the current line
            int totalChars = words[index].length();
            int last = index + 1;
            // Find the last word that fits in the line
            while (last < words.length) {
                // +1 for the space
                // Check if adding the next word exceeds maxWidth
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                // Update total characters count
                totalChars += 1 + words[last].length();
                last++;
            }

            // Build the justified line
            StringBuilder sb = new StringBuilder();
            // Number of words in the current line
            int numberOfWords = last - index;
            // If it's the last line or contains only one word, left-justify
            if (last == words.length || numberOfWords == 1) {
                // Append words with a single space
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i != last - 1) sb.append(" ");
                }
                // Fill the remaining spaces to reach maxWidth
                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            // Otherwise, fully justify the line
            } else {
                // Calculate total spaces to distribute
                int totalSpaces = maxWidth - totalChars + (numberOfWords - 1);
                // Calculate space between words and extra spaces
                int spaceBetweenWords = totalSpaces / (numberOfWords - 1);
                int extraSpaces = totalSpaces % (numberOfWords - 1);

                // Append words with calculated spaces
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    // Add spaces between words
                    if (i != last - 1) {
                        // Add the calculated spaces
                        for (int s = 0; s < spaceBetweenWords; s++) {
                            sb.append(" ");
                        }
                        // Distribute extra spaces to the left slots
                        if (extraSpaces > 0) {
                            sb.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }
            result.add(sb.toString());
            // Move to the next line
            index = last;
        }
        return result;
    }

}