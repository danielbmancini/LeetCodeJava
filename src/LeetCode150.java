import java.util.Stack;

public class LeetCode150 {
    /*Yocê recebe um array de tokens de strings que representam uma expressão aritmética em uma Notação Polonesa Reversa.

Avalie a expressão. Retorne um inteiro que representa o valor da expressão.*/
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
