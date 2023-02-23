package sqrt_69;

/*
    Given a non-negative integer x, compute and return the square root of x.
    Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 */
public class Main {
    public static int mySqrt(int x) {
        int l=0, r=x;
        if(0 == x){
            return 0;
        }
        if(1 == x){
            return 1;
        }

        int mid;
        while (l < r-1){
            mid = l + (r-l) / 2;

            int div = x / mid;
            if(div == mid){
                return mid;
            }else if(div > mid){
                l = mid;
            }else{
                r = mid;
            }
        }

        return l;
    }

    public static void main(String[] args){
        System.out.println(mySqrt(2147395599));
    }
}
