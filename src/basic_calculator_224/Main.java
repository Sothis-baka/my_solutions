package basic_calculator_224;

public class Main {
    /*private static class Expr{
        Expr expr1, expr2;
        Character op;
        Integer val;

        Expr(String s){
            if(s.charAt(s.length() - 1) == ')'){
                int index = s.length() - 1;
                int count = 1;
                while (count > 0){
                    index--;
                    if(s.charAt(index) == '('){
                        count--;
                    }else if(s.charAt(index) == ')'){
                        count++;
                    }
                }

                if(index > 1){
                    expr1 = new Expr(s.substring(0, index-1));
                }
                op = index > 0 ? s.charAt(index - 1) : '+';
                expr2 = new Expr(s.substring(index+1, s.length()-1));
            }else{
                int indexOp = Math.max(s.lastIndexOf('+'), s.lastIndexOf('-'));

                if(indexOp <= 0){
                    val = Integer.parseInt(s);
                    return;
                }

                expr1 = new Expr(s.substring(0, indexOp));
                op = s.charAt(indexOp);
                expr2 = new Expr(s.substring(indexOp + 1));
            }
        }

        public int val(){
            return this.val == null ? (this.expr1 == null ? 0 : this.expr1.val()) + (this.op == '+' ? this.expr2.val() : -this.expr2.val()) : this.val;
        }
    }

    public static int calculate(String s) {
        s = s.replaceAll(" ", "");
        Expr expr = new Expr(s);

        return expr.val();
    }*/

    public static int calculate(String s) {
        // Remove spaces
        s = s.replaceAll(" ", "");
        return calculateHelper(s, 0, s.length()-1);
    }

    /* Helper function to calculate a function */
    private static int calculateHelper(String s, int start, int end){
        if(s.charAt(end) == ')'){
            // Find corresponding parenthesis
            int index = end, count = 1;
            while (count > 0){
                index--;
                if(s.charAt(index) == '('){
                    count--;
                }else if(s.charAt(index) == ')'){
                    count++;
                }
            }

            int value1 = index > start + 1 ? calculateHelper(s, start, index-2) : 0;
            char op = index > start ? s.charAt(index - 1) : '+';
            int value2 = calculateHelper(s, index+1,  end-1);

            return value1 + (op == '+' ? value2 : -value2);
        }

        // Find the last operation in the function
        int index = -1;
        for(int i=end; i>=start; i--){
            if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                index = i;
                break;
            }
        }

        // It's a valid integer
        if(index <= start){
            return Integer.parseInt(s.substring(start, end+1));
        }

        int value1 = calculateHelper(s, start, index-1);
        char op =  s.charAt(index);
        int value2 = calculateHelper(s, index+1,  end);

        return value1 + (op == '+' ? value2 : -value2);
    }

    public static void main(String[] args){
        /*System.out.println(calculate(" 2-1 + 2 "));
        System.out.println(calculate("1 + 1"));*/
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
