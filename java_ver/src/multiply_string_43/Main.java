package multiply_string_43;

/*
    Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 */
public class Main {
    public static String multiply(String num1, String num2) {
        // Special case multiply by zero
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }

        int l1 = num1.length(), l2 = num2.length();
        int[] result = new int[l1 + l2];
        // Multiply digit by digit
        for(int i=l1-1; i>=0; i--){
            for(int j=l2-1; j>=0; j--){
                result[i+j+1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        for(int i=l1+l2-1; i>=0; i--){
            // Only reserve one digit.
            if(i != 0)
                result[i-1] += result[i] / 10;

            result[i] = result[i] % 10;
        }

        StringBuilder strBd = new StringBuilder();
        boolean start = false;
        for(int temp: result){
            // Skip leading zeros and convert to string
            if(start){
                strBd.append(temp);
            }else{
                if(temp != 0){
                    start = true;
                    strBd.append(temp);
                }
            }
        }

        return strBd.toString();
    }

    public static void main(String[] args){
        System.out.println(multiply("0", "3"));
    }
}
