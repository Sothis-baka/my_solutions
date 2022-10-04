package count_special_integers_2376;

/*
    We call a positive integer special if all of its digits are distinct.
    Given a positive integer n, return the number of special integers that belong to the interval [1, n].
 */
public class Main {
    int origin;

    public int countSpecialNumbers(int n) {
        origin = n;
        int digits = 0;
        while (n > 0){
            n /= 10;
            digits++;
        }
        return helper(digits, new StringBuilder());
    }

    private int helper(int digits, StringBuilder strBd){
        if(digits == 0){
            if(Integer.parseInt(strBd.toString()) == 0) return 0;
            return strBd.toString().compareTo(String.valueOf(origin)) <= 0 ? 1 : 0;
        }

        int count = 0;
        digits--;

        for(int i=0; i<=9; i++){
            if(isValid(strBd, i)){
                strBd.append(i);
                count += helper(digits, strBd);
                strBd.deleteCharAt(strBd.length() - 1);
            }
        }
        return count;
    }

    private boolean isValid(StringBuilder strBd, int i){
        if(i != 0){
            return strBd.indexOf(String.valueOf(i)) < 0;
        }

        int last = strBd.lastIndexOf("0");
        if(last < 0) return true;
        for(int j=0; j<last; j++) if(strBd.charAt(j) != '0') return false;
        return true;
    }

    public static void main(String[] args){
        System.out.println(new Main().countSpecialNumbers(135));
    }
}
