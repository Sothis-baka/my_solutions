package adding_spaces_to_a_string_2109;

/*
    You are given a 0-indexed string s and a 0-indexed integer array spaces that describes the indices in the original string where spaces will be added. Each space should be inserted before the character at the given index.

    For example, given s = "EnjoyYourCoffee" and spaces = [5, 9], we place spaces before 'Y' and 'C', which are at indices 5 and 9 respectively. Thus, we obtain "Enjoy Your Coffee".
    Return the modified string after the spaces have been added.
 */
public class Main {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder strBd = new StringBuilder();

        int last = 0;
        for(int space: spaces){
            strBd.append(s, last, space);
            strBd.append(" ");
            last = space;
        }

        strBd.append(s, last, s.length());

        return strBd.toString();
    }

    public static void main(String[] args){
        System.out.println(new Main().addSpaces("spacing", new int[]{0,1,2,3,4,5,6}));
    }
}
