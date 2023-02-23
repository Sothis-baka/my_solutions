package time_needed_to_rearrange_a_binary_string_2380;

public class Main {
    /*
        You are given a binary string s. In one second, all occurrences of "01" are simultaneously replaced with "10". This process repeats until no occurrences of "01" exist.
        Return the number of seconds needed to complete this process.
     */
    public int secondsToRemoveOccurrences(String s) {
        int count = 0;
        while (s.contains("01")){
            s = s.replaceAll("01", "10");
            count++;
        }

        return count;
    }
}
