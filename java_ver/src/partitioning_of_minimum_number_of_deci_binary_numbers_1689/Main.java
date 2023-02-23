package partitioning_of_minimum_number_of_deci_binary_numbers_1689;

/*
    A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros. For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
    Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary numbers needed so that they sum up to n.
 */
public class Main {
    public int minPartitions(String n) {
        // Greedy
        // For each char, if it's larger than count, we count the diff
        int count = 0;
        for(char ch: n.toCharArray()){
            count += Math.max(ch - '0' - count, 0);
        }

        return count;
    }
}
