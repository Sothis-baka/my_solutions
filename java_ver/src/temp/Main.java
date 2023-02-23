package temp;

import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void checkEqual(int[][] myArray, int[][] newArray) {
        if(myArray.length != newArray.length || myArray.length > 0 && myArray[0].length != newArray[0].length) {
            System.out.println("false");
            return;
        }

        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[0].length; j++) {
                if (myArray[i][j] != newArray[i][j]) {
                    System.out.println("Two Matrix are not equal");
                    return;
                } // end for j
            } // end for i
        }

        System.out.println("Two Matrix are equal");
    }

    public static void main(String[] args){

    }

}