package parsing_a_boolean_expression_1106;

/*
    A boolean expression is an expression that evaluates to either true or false. It can be in one of the following shapes:

    't' that evaluates to true.
    'f' that evaluates to false.
    '!(subExpr)' that evaluates to the logical NOT of the inner expression subExpr.
    '&(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical AND of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
    '|(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical OR of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
    Given a string expression that represents a boolean expression, return the evaluation of that expression.

    It is guaranteed that the given expression is valid and follows the given rules.
*/
public class Main {
    public boolean parseBoolExpr(String expression) {
        System.out.println(expression);
        /*
            switch(exp):{
                // base
                "t" -> true
                "f" -> false
                "(...)" -> parse
                "!(...)" -> !parse()
                "&" -> all parse
                "|" -> any parse
            }
         */

        /*
            Parse all inner parenthesis
         */
        int indexClose = expression.indexOf(')');
        if(indexClose > 0 && indexClose < expression.length() - 1){
            int indexOpen = expression.lastIndexOf('(', indexClose);
            return parseBoolExpr(expression.substring(0, indexOpen - 1)
                    + (parseBoolExpr(expression.substring(indexOpen - 1, indexClose + 1)) ? "t" : "f")
                    + expression.substring(indexClose + 1));
        }

        switch (expression){
            case "t" -> {
                return true;
            }

            case "f" -> {
                return false;
            }

            default -> {
                char ch = expression.charAt(0);
                switch (ch) {
                    case '!' -> {
                        return !parseBoolExpr(expression.substring(2, expression.length() - 1));
                    }

                    case '&' -> {
                        for(String subExpr: parseExpressions(expression.substring(2, expression.length() - 1))){
                            if(!parseBoolExpr(subExpr)) return false;
                        }
                        return true;
                    }

                    case '|' -> {
                        for(String subExpr: parseExpressions(expression.substring(2, expression.length() - 1))){
                            if(parseBoolExpr(subExpr)) return true;
                        }
                        return false;
                    }

                    default -> {
                        return false;
                    }
                }
            }
        }
    }

    /*
        Parse an array of expressions in format (e1, e1, e3 ...)
     */
    private String[] parseExpressions(String exprs){
        return exprs.split(",");
    }

    public static void main(String[] args){
        System.out.println(new Main().parseBoolExpr("|(f,&(t,t))"));
    }
}
