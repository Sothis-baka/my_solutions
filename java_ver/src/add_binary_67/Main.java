package add_binary_67;

/*
    Given two binary strings a and b, return their sum as a binary string
 */
public class Main {
    public static String addBinary(String a, String b) {
        int lengthA = a.length(), lengthB = b.length();
        int possibleLength = Math.max(lengthA, lengthB) + 1;
        int[] cache = new int[possibleLength];
        boolean addOn = false;
        for(int i=1; i<=possibleLength; i++){

            cache[possibleLength - i] = (i <= lengthA ? a.charAt(lengthA-i) - '0' : 0) + (i<=lengthB ? b.charAt(lengthB-i) - '0' : 0) + (addOn ? 1 : 0);

            if(cache[possibleLength - i] >= 2){
                cache[possibleLength - i] -= 2;
                addOn = true;
            }else{
                addOn = false;
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i=0; i<possibleLength; i++){
            if(i==0 && cache[i]==0){
                continue;
            }

            result.append(cache[i]);
        }

        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(addBinary("11", "111"));
    }
}
