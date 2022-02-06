package reverse_bits_190;

/*
    Reverse bits of a given 32 bits unsigned integer.
 */
public class Main {
    public static int reverseBits(int n) {
        int result = 0;

        for(int i=0; i<32; i++){
            result = (result << 1) | (n & 1);
            n = n >> 1;
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(reverseBits(-3));
    }
}
