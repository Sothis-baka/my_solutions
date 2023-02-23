package check_distances_between_same_letters_2399;

/*
    You are given a 0-indexed string s consisting of only lowercase English letters, where each letter in s appears exactly twice. You are also given a 0-indexed integer array distance of length 26.
    Each letter in the alphabet is numbered from 0 to 25 (i.e. 'a' -> 0, 'b' -> 1, 'c' -> 2, ... , 'z' -> 25).
    In a well-spaced string, the number of letters between the two occurrences of the ith letter is distance[i]. If the ith letter does not appear in s, then distance[i] can be ignored.
    Return true if s is a well-spaced string, otherwise return false.
 */
public class Main {
    public boolean checkDistances(String s, int[] distance) {
        // Iterate the string,
        // for ch, if the distance is positive, mark the distance as a negative value
        // if the distance is negative, compare them,
        // If there are negative value remains in distance, return false;

        int length = s.length();
        for(int i=0; i<length; i++){
            char ch = s.charAt(i);
            int index = ch - 'a';

            // Visited
            if(distance[index] < 0){
                // Visited but the distance not match
                if(i != - distance[index]) return false;
            }
            else{
                // Desired position is distance[index] + i, save as negative
                distance[index] = -(distance[index] + i + 1);
            }
        }

        return true;
    }
}
