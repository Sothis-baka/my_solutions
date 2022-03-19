package output_contest_matches_544;

/*
    During the NBA playoffs, we always arrange the rather strong team to play with the rather weak team, like make the rank 1 team play with the rank nth team, which is a good strategy to make the contest more interesting. Now, you're given n teams, you need to output their final contest matches in the form of a string.
    The n teams are given in the form of positive integers from 1 to n, which represents their initial rank. (Rank 1 is the strongest team and Rank n is the weakest team.) We'll use parentheses('(', ')') and commas(',') to represent the contest team pairing - parentheses('(' , ')') for pairing and commas(',') for partition. During the pairing process in each round, you always need to follow the strategy of making the rather strong one pair with the rather weak one.
 */
public class Main {
    public static String findContestMatch(int n) {
        String[] matches = new String[n];
        for(int i=0; i<n; i++) matches[i] = String.valueOf(i+1);

        while(n > 1){
            n /= 2;
            for(int i=0; i<n; i++) matches[i] = "(" + matches[i] + "," + matches[2 * n - 1 - i] + ")";
        }

        return matches[0];
    }

    public static void main(String[] args){
        System.out.println(findContestMatch(2));
        System.out.println(findContestMatch(4));
        System.out.println(findContestMatch(8));
    }
}
