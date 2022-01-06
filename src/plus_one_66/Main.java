package plus_one_66;

/*
    You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
    Increment the large integer by one and return the resulting array of digits.
 */
public class Main {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        boolean notEnd = true;
        while(notEnd && index >= 0){
            if(digits[index] < 9){
                digits[index]++;
                notEnd = false;
            }else{
                digits[index] = 0;
                index--;
            }
        }

        if(notEnd){
            int[] newArr = new int[digits.length + 1];
            System.arraycopy(digits, 0, newArr, 1, digits.length);
            newArr[0] = 1;
            return newArr;
        }

        return digits;
    }
}
