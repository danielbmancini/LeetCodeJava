import java.util.Stack;

public class LeetCode150 {
    /*You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.*/
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            try {
                int k = Integer.parseInt(token);
                stack.push(k);
            } catch (NumberFormatException e) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(operate(token, b, a));

            }
        }
        return stack.peek();
    }

    private static int operate(String token, int a, int b) {
        switch (token) {
            case "*":
                return a * b;
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "/":
                return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
