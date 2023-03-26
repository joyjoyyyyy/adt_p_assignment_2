public class Expression {
    private String infix;
    private Stack<Character> stack;

    public Expression(String infix) {
        this.infix = infix;
        this.stack = new Stack<>();
    }
    
    public String toPostfix() {
        StringBuilder postfix = new StringBuilder();
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (isOperand(c)) {
                postfix.append(c);
            } else if (isOperator(c)) {
                while (!stack.isEmpty() && stack.peek() != '(' && hasHigherPrecedence(stack.peek(), c)) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }
    
    private boolean hasHigherPrecedence(char operator, char currentOperator) {
        if (operator == '*' || operator == '/') {
            return true;
        } else if (operator == '+' || operator == '-') {
            return (currentOperator == '+' || currentOperator == '-');
        } else {
            return false;
        }
    }
    
    private boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }
    
    private boolean isOperand(char c) {
        return (Character.isLetterOrDigit(c) || c == '.' || c == '_');
    }
}
