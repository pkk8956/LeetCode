package Arrays_and_Strings;

public class LC_6 {

    // Zigzag Conversion

    /* The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
    (you may want to display this pattern in a fixed font for better legibility)
    And then read line by line: "PAHNAPLSIIGYIR"
    Write the code that will take a string and make this conversion given a number of rows.*/

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        LC_6 obj = new LC_6();
        System.out.println(obj.convert(s, numRows));
    }

    public String convert(String s, int numRows) {
        // Edge case: if numRows is 1 or string length is less than or equal to numRows
        if (numRows == 1 || s.length() <= numRows) return s;

        // Create an array of StringBuilders for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        // Initialize each StringBuilder
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        // Variables to track the current row and direction
        int currentRow = 0;
        boolean goingDown = false;

        // Build the zigzag pattern
        for (char c : s.toCharArray()) {
            // Append character to the current row
            rows[currentRow].append(c);
            // Change direction if we reach the top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            // Move to the next row  
            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
    
}
