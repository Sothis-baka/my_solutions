package reverse_bits_190;

/*
    Reverse bits of a given 32 bits unsigned integer.
 */
public class Main {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String binaryString = Integer.toBinaryString(n);
        StringBuilder strBd = new StringBuilder(binaryString);
        strBd = strBd.reverse();
        strBd.append("0".repeat(32 - strBd.length()));
        return (int) Long.parseLong(strBd.toString(), 2);
    }
}
