package Other;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class CharacterEncodings {

    public static void main(String[] args) {
        String text = "AЖ你🙂";

        System.out.println("Текст: " + text);

        // ASCII
        byte[] asciiBytes = text.getBytes(StandardCharsets.US_ASCII);
        System.out.println("ASCII : " + Arrays.toString(asciiBytes));
        System.out.println("ASCII : " + asciiBytes.length);

        // UTF-8
        byte[] utf8Bytes = text.getBytes(StandardCharsets.UTF_8);
        System.out.println("UTF-8: " + Arrays.toString(utf8Bytes));
        System.out.println("UTF-8: " + utf8Bytes.length);

        // UTF-16
        byte[] utf16Bytes = text.getBytes(StandardCharsets.UTF_16);
        System.out.println("UTF-16: " + Arrays.toString(utf16Bytes));
        System.out.println("UTF-16: " + utf16Bytes.length);

        // UTF-32
        int[] codePoints = text.codePoints().toArray();
        byte[] utf32Bytes = new byte[codePoints.length * 4];
        for (int i = 0; i < codePoints.length; i++) {
            int cp = codePoints[i];
            utf32Bytes[i * 4]     = (byte) ((cp >> 24) & 0xFF);
            utf32Bytes[i * 4 + 1] = (byte) ((cp >> 16) & 0xFF);
            utf32Bytes[i * 4 + 2] = (byte) ((cp >> 8) & 0xFF);
            utf32Bytes[i * 4 + 3] = (byte) (cp & 0xFF);
        }
        System.out.println("UTF-32: " + Arrays.toString(utf32Bytes));
        System.out.println("UTF-32: " + utf32Bytes.length);

    }
}
