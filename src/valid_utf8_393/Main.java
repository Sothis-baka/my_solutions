package valid_utf8_393;

public class Main {
    public static boolean validUtf8(int[] data) {
        int remain = 0;
        for(int temp: data){
            if(remain > 0){
                if(temp >> 6 != 2){
                    return false;
                }
                remain--;
            }else{
                int i = 7;
                while (i >= 4 && (temp >> i) % 2 == 1){
                    i--;
                    remain++;
                }
                if(i == 6 || (temp >> i) % 2 != 0){
                    return false;
                }
                remain = remain == 0 ? 0 : remain-1;
            }
        }

        return remain == 0;
    }

    public static void main(String[] args){
        System.out.println(validUtf8(new int[]{248,130,130,130}));
    }
}
