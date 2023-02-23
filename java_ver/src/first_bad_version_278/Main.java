package first_bad_version_278;

import java.util.Random;

/*
    You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
    Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
    You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
*/
public class Main {
    public static int firstBadVersion(int n) {
        if(isBadVersion(1)){
            return 1;
        }

        return searchHelper(1, n);
    }

    private static int searchHelper(int start, int end){
        if(start == end){
            return end;
        }else if(start == end - 1){
            return isBadVersion(start) ? start : end;
        }

        int mid = start / 2 + end / 2 + (start % 2 == 1 && end % 2 == 1 ? 1 : 0);
        if(isBadVersion(mid)){
            return searchHelper(start, mid);
        }else{
            return searchHelper(mid, end);
        }
    }

    // Provided function
    private static boolean isBadVersion(int version){
        return version == 1702766719;
        // return new Random().nextBoolean();
    }

    public static void main(String[] args){
        System.out.println(firstBadVersion(2126753390));
    }
}
