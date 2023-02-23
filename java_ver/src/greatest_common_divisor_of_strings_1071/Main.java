package greatest_common_divisor_of_strings_1071;

/*
    For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).

    Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 */
public class Main {
    /*
        Function to find the longest string that can be divisible of two input strings

        if str1 == str * m, str2 = str * n
        str1 + str2 must == str2 + str1

        if str1 + str2 == str2 + str1
            if str1.length == str2.length
            str1 == str2
            else if str1.length < str2.length
            str2[0, l1] = str1
            str2[l1, 2l1] = str2[0, l1] = str1
            (if end index larger than length, use the part from str1)

        So that they must have a common divisor
    */
    public String gcdOfStrings(String str1, String str2) {
        /* Exactly match */
        if(str1.equals(str2))
            return str1;

        /*
            No common factor
        */
        if(!(str1 + str2).equals(str2 + str1))
            return "";

        /*
            The maximum length of the substring that can be divisor of both
            has a length with maximum common divisor of both lengths.
         */
        int factorLength = maximumCommonFactor(str1.length(), str2.length());
        return str1.substring(0, factorLength);
    }

    /*
        Find the maximum common factor for two numbers
        num1 > num2 >= 0
     */
    private int maximumCommonFactor(int num1, int num2){
        // Exactly divide, num2 is a factor of num1
        if(num2 == 0) return num1;

        // Put the smaller one at front, recursively find the result
        return maximumCommonFactor(num2, num1 % num2);
    }
}
