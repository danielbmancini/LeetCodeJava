import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeetCode592 {
    /*
    Dada uma expressão em formato de string representando uma operação de adição e subtração de frações, retorne o resultado do cálculo também em formato de string.

O resultado final deve ser uma fração irredutível. Se o resultado final for um número inteiro, converta-o para o formato de uma fração com denominador 1. Neste caso, 2 deve ser convertido para 2/1.
     */
    Pattern pattern = Pattern.compile("\\d+|[+\\-\\\\]"); //tokenizar por qualquer quantia de digito ou - ou + ou \
    Pattern result = Pattern.compile("-?\\d+/\\d+");
    Pattern twoFractions = Pattern.compile("([+-]?\\d+/\\d+)([+-]?\\d+/\\d+)");

    public String fractionAddition(String expression){
        Matcher matcher = result.matcher(expression);
        if(matcher.matches())
            return expression;
        Matcher matcher1 = twoFractions.matcher(expression);

        String add = addFractions(matcher1.group(1),matcher1.group(2));

        return fractionAddition(add + matcher.end());
    }

    public static void main(String[] args) {
        LeetCode592 leetCode592 = new LeetCode592();

        System.out.println(leetCode592.fractionAddition("-1/2+1/2"));
    }

    public static String addFractions(String frac1, String frac2) {
        int[] f1 = parse(frac1);
        int[] f2 = parse(frac2);

        // a/b + c/d = (a*d + b*c) / (b*d)
        int num =  f1[0] * f2[1] +  f1[1] * f2[0];
        int den =  f1[1] * f2[1];

        return String.valueOf(num) + "/" + String.valueOf(den);
    }

    private static int[] parse(String s) {
        s = s.trim().replace(")", "").replace("(", "");
        if (s.startsWith("+")) s = s.substring(1);

        String[] parts = s.split("/");

        return new int[]{
                Integer.parseInt(parts[0].trim()),
                Integer.parseInt(parts[1].trim())
        };
    }

}
