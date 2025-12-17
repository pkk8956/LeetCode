package Bit_Manipulation;

public class BitwiseOperators {

    public static void main(String[] args) {
        int a = 5;
        int b = 3;

        // Bitwise AND, OR, XOR, NOT
        System.out.println(a & b);
        System.out.println(a | b);
        System.out.println(a ^ b);
        System.out.println(~a);
        // Left shift and Right shift
        System.out.println(a << 1);
        System.out.println(a >> 1);

        // Using bitwise operators for flags
        int flags = 0;
        int READ = 1 << 0;
        int WRITE = 1 << 1;
        int EXEC = 1 << 2;

        flags |= READ;
        flags |= WRITE;

        
        System.out.println((flags & READ) != 0);
        System.out.println((flags & EXEC) != 0);
    }
}

