package solve_the_equation_640;

/*
    Solve a given equation and return the value of 'x' in the form of a string "x=#value". The equation contains only '+', '-' operation, the variable 'x' and its coefficient. You should return "No solution" if there is no solution for the equation, or "Infinite solutions" if there are infinite solutions for the equation.
    If there is exactly one solution for the equation, we ensure that the value of 'x' is an integer.
 */
public class Main {
    public String solveEquation(String equation) {
        String[] eqs = equation.split("=");

        int[] arr1 = parse(eqs[0]), arr2 = parse(eqs[1]);
        if(arr1[1] == arr2[1]) return arr1[0] == arr2[0] ? "Infinite solutions" : "No solution";
        return "x=" + (arr1[0] - arr2[0]) / (arr2[1] - arr1[1]);
    }

    private int[] parse(String eq){
        int val = 0, xCount = 0, curVal = 0;
        boolean positive = true, modified = false;
        for(char ch: eq.toCharArray()){
            switch (ch){
                case '+', '-' -> {
                    val += positive ? curVal : - curVal;
                    positive = ch == '+';
                    curVal = 0;
                    modified = false;
                }
                case 'x' -> {
                    if(!modified) curVal = 1;
                    xCount += positive ? curVal : -curVal;
                    curVal = 0;
                    modified = false;
                }
                default -> {
                    curVal *= 10;
                    curVal += ch - '0';
                    modified = true;
                }
            }
        }
        val += positive ? curVal : - curVal;

        return new int[]{val, xCount};
    }
}
