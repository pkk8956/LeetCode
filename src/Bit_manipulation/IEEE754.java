package Bit_Manipulation;

public class IEEE754 {

    public static void main(String[] args) {
        double f = 5.625;
        double d = -0.1;

        String floatBits = floatToIEEE754(f);
        String doubleBits = doubleToIEEE754(d);

        System.out.println("Float: " + f + " --> " + floatBits + " --> " + bitsToFloat(floatBits));
        System.out.println("Double: " + d + " --> " + doubleBits + " --> " + bitsToDouble(doubleBits));
    }

    static String floatToIEEE754(double value) {
        return toIEEE754(value, 8, 23, 127);
    }

    static String doubleToIEEE754(double value) {
        return toIEEE754(value, 11, 52, 1023);
    }

    static String toIEEE754(double value, int expBits, int mantBits, int bias) {
        int sign = value < 0 ? 1 : 0;
        value = Math.abs(value);

        long intPart = (long) value;
        double fracPart = value - intPart;

        String intBin = Long.toBinaryString(intPart);
        StringBuilder fracBin = new StringBuilder();

        for (int i = 0; i < mantBits * 2; i++) {
            fracPart *= 2;
            if (fracPart >= 1) {
                fracBin.append('1');
                fracPart -= 1;
            } else {
                fracBin.append('0');
            }
        }

        int exponent;
        String mantissa;

        if (intPart != 0) {
            exponent = intBin.length() - 1;
            mantissa = intBin.substring(1) + fracBin;
        } else {
            int firstOne = fracBin.indexOf("1");
            exponent = -(firstOne + 1);
            mantissa = fracBin.substring(firstOne + 1);
        }

        int expValue = exponent + bias;
        String expBin = toBinary(expValue, expBits);
        mantissa = padRight(mantissa, mantBits).substring(0, mantBits);

        return sign + expBin + mantissa;
    }

    static double bitsToFloat(String bits) {
        return bitsToDecimal(bits, 8, 23, 127);
    }

    static double bitsToDouble(String bits) {
        return bitsToDecimal(bits, 11, 52, 1023);
    }

    static double bitsToDecimal(String bits, int expBits, int mantBits, int bias) {
        int sign = bits.charAt(0) - '0';
        String expStr = bits.substring(1, 1 + expBits);
        String mantStr = bits.substring(1 + expBits);

        int exponent = Integer.parseInt(expStr, 2) - bias;
        double mantissa = 1.0;

        for (int i = 0; i < mantStr.length(); i++) {
            if (mantStr.charAt(i) == '1') {
                mantissa += Math.pow(2, -(i + 1));
            }
        }

        return Math.pow(-1, sign) * mantissa * Math.pow(2, exponent);
    }

    static String toBinary(int value, int bits) {
        String s = Integer.toBinaryString(value);
        return "0".repeat(bits - s.length()) + s;
    }

    static String padRight(String s, int len) {
        return s + "0".repeat(Math.max(0, len - s.length()));
    }
}

