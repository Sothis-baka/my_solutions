package read_four_157;

/*
    int read4(char *buf) reads 4 characters at a time from a file.
    The return value is the actual number of characters read. For example, it returns 3 if there
    is only 3 characters left in the file.
    By using the read4 API, implement the function int read(char *buf, int n) that reads n
    characters from the file.
    Note: The read function will only be called once for each test case.
 */
public class Main {
    final private static String FILE = "leetcode157";
    final private static int LENGTH = 11;
    private static int index = 0;

    // Provided function, read 4 characters from source file into buf, return real length of content.
    private static int read4(char[] buf){
        for(int i=0; i<4; i++){
            if(index == LENGTH)
                return i;
            buf[i] = FILE.charAt(index); index++;
        }
        return 4;
    }

    public static int read(char[] buf,int n) {
        char[] temp = new char[4];
        int length = 0, cur;
        while (n > 0){
            cur = read4(temp);
            System.arraycopy(temp, 0, buf, length, Math.min(cur, n));
            length += cur;
            n -= cur;
            if(cur < 4)
                break;
        }
        return length;
    }

    public static void main(String[] args){
        char[] result = new char[13];
        System.out.println(read(result, 13));
        for(char ch: result){
            System.out.print(ch);
        }
        System.out.println();
    }
}
