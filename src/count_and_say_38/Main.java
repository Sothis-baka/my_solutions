package count_and_say_38;

/*
    Description is too long, check the original website for it.
 */
public class Main {
    public static String countAndSay(int n) {
        if(n == 1){
            return "1";
        }

        return say(countAndSay(n-1));
    }

    private static String say(String input){
        StringBuilder strBd = new StringBuilder();

        char last = 'a', cur;
        int count = 0;
        int index = 0, length = input.length();
        while (index < length){
            cur = input.charAt(index);
            if(last == 'a' || cur != last){
                if(count != 0){
                    strBd.append(count);
                    strBd.append(last);
                }


                last = cur;
                count = 1;
            }else{
                count++;
            }

            index++;
        }

        strBd.append(count);
        strBd.append(last);

        return strBd.toString();
    }

    public static void main(String[] args){
        for(int i=1; i<5; i++)
            System.out.println(countAndSay(i));
    }
}
