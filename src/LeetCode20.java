import java.util.Stack;

public class LeetCode20 {
    public static boolean isValid(String s) {
        Stack<Integer> stack = new Stack<>();
        if(s.length() == 1)
            return false;
        for(Character character : s.toCharArray()){

            switch(character) {
                case '(':
                    stack.push(1);
                    break;
                case ')':
                    stack.push(-1);
                    break;
                case '[':
                    stack.push(2);
                    break;
                case ']':
                    stack.push(-2);
                    break;
                case '{':
                    stack.push(3);
                    break;
                case '}':
                    stack.push(-3);
                    break;

            }
        }
            Stack<Integer> otherStack = new Stack<>();

            while(!stack.isEmpty() ){
                int peek = stack.peek();
                if(stack.size() == 1 && otherStack.isEmpty())
                    return false;

                if (peek < 0){
                    otherStack.push(peek);
                    //stack.pop();
                } else if(otherStack.isEmpty()){
                    return false;
                }else if (peek != -otherStack.pop()){
                    return false;
                }
                stack.pop();
            }
        return otherStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("[{}{{}}[]]"));
    }


}
