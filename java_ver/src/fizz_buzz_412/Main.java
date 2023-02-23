package fizz_buzz_412;

import java.util.ArrayList;
import java.util.List;

/*
    Given an integer n, return a string array answer (1-indexed) where:

    answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
    answer[i] == "Fizz" if i is divisible by 3.
    answer[i] == "Buzz" if i is divisible by 5.
    answer[i] == i (as a string) if none of the above conditions are true.
 */
public class Main {
    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for(int i=1; i<=n; i++){
            boolean by3 = i%3==0, by5 = i%5==0;
            if(by3){
                if(by5){
                    result.add("FizzBuzz");
                }else{
                    result.add("Fizz");
                }
            }else if(by5){
                result.add("Buzz");
            }else{
                result.add(Integer.toString(i));
            }
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(fizzBuzz(10));
    }
}
