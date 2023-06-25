import java.util.Stack;

public class LeetCode13 {
    //Given a roman numeral, convert it to an integer.

    private static Stack<Integer> integers = new Stack<>();
    public static int romanToInt(String s) {
        int numeral = 0;
        for(char character : s.toCharArray())
            switch(character){
                case 'I':
                   integers.push(1);
                   break;
                case 'V':
                    integers.push(5);
                    break;
                case 'X':
                    integers.push(10);
                    break;
                case 'L':
                    integers.push(50);
                    break;
                case 'C':
                    integers.push(100);
                    break;
                case 'D':
                    integers.push(500);
                    break;
                case 'M':
                    integers.push(1000);
                    break;
            }

        int last = integers.peek();

        while (!integers.isEmpty()){
            int current = integers.pop();
            if(last < current){
                numeral += current;
                last = current;
            }
            else if (last == current)
                numeral += current;
            else
                numeral -= current;

        }

        return numeral;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
