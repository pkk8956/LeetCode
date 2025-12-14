package Bit_manipulation;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Endianness {

    public static void main(String[] args) {
        int value = 0x12345678;

        ByteBuffer bigEndian = ByteBuffer.allocate(4);
        bigEndian.putInt(value);

        ByteBuffer littleEndian = ByteBuffer.allocate(4);
        littleEndian.order(ByteOrder.LITTLE_ENDIAN);
        littleEndian.putInt(value);

        System.out.println("Value: 0x12345678");
        System.out.println("Big Endian bytes:    " + toHex(bigEndian.array()));
        System.out.println("Little Endian bytes: " + toHex(littleEndian.array()));

        int readBig = ByteBuffer.wrap(bigEndian.array()).getInt();
        int readLittle = ByteBuffer.wrap(littleEndian.array())
                .order(ByteOrder.LITTLE_ENDIAN)
                .getInt();

        System.out.println("Read Big Endian:    0x" + Integer.toHexString(readBig));
        System.out.println("Read Little Endian: 0x" + Integer.toHexString(readLittle));
    }

    private static String toHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString().trim();
    }
}
